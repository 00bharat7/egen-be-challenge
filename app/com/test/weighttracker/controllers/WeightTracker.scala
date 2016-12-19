package com.test.weighttracker.controllers

import com.sun.media.sound.InvalidDataException
import com.test.weighttracker.manager.WeightTrackManager
import com.test.weighttracker.model.{AlertRequest, MetricRequest}
import play.api.mvc.{Action, Controller, Result}

import scala.concurrent.Future
import scala.util.{Failure, Success, Try}
import net.liftweb.json._
import net.liftweb.json.Serialization.write

/**
  * Created by bharaka on 12/17/16.
  */
object WeightTracker extends WeightTracker

trait WeightTracker extends Controller {

  val weightTrackManager: WeightTrackManager = new WeightTrackManager {}
  implicit val formats = DefaultFormats

  /**
    * POST /metrics/create (create metrics)
    *
    * @return If success: HTTP 200 with the created EventId. Otherwise, HTTP error (400, 500).
    */
  def postMetrics(baseWeight:String) = Action{ request =>
      val jsonString = request.body.asJson.get.toString
      val inputMetrics: Try[MetricRequest] = validateMetrics(net.liftweb.json.parse(jsonString).extract[MetricRequest],baseWeight)
      val resultFuture: Future[Try[String]] = inputMetrics match {
        case Success(metrics) =>
          weightTrackManager.processSave(metrics,baseWeight)
        case Failure(e) =>
          val badMsg="Failed to insert Metrics - Invalid Data"
          Future.successful(Try(badMsg))
      }
      Ok(resultFuture.value.get.get.get)
  }

  /**
    * GET /metrics/read (fetch metrics)
    *
    * @return If success: HTTP 200 with the metric list. Otherwise, HTTP error (400, 500).
    */
  def fetchMetrics = Action{ request =>
    val metricList: Future[Either[Exception, List[MetricRequest]]] = weightTrackManager.fetchMetrics
    Ok(write(metricList.value.get.get))
  }

  /**
    * GET /alerts/readByTimeRange (fetch metrics by time range)
    *
    * @return If success: HTTP 200 with the metric list. Otherwise, HTTP error (400, 500).
    */
  def fetchMetricsByTimeRange(from:Option[String],to:Option[String]) = Action{ request =>
    val metric: Future[Either[Exception, List[MetricRequest]]] = weightTrackManager.fetchMetricsByTimeRange(from,to)
    Ok(write(metric.value.get.get))
  }


  /**
    * GET /alerts/read (fetch alerts)
    *
    * @return If success: HTTP 200 with the alert list. Otherwise, HTTP error (400, 500).
    */
  def fetchAlerts = Action{ request =>
    val alertList: Future[Either[Exception, List[AlertRequest]]] = weightTrackManager.fetchAlerts
    Ok(write(alertList.value.get.get))
  }

  /**
    * GET /alerts/readByTimeRange (fetch alerts by time range)
    *
    * @return If success: HTTP 200 with the alert list. Otherwise, HTTP error (400, 500).
    */
  def fetchAlertsByTimeRange(from:Option[String],to:Option[String]) = Action{ request =>
    val alert: Future[Either[Exception, List[AlertRequest]]] = weightTrackManager.fetchAlertsByTimeRange(from,to)
    Ok(write(alert.value.get.get))
  }

  def validateMetrics(metrics:MetricRequest,baseWeight:String): Try[MetricRequest] = Try {
    require(metrics.timeStamp.nonEmpty, "Input metrics data must contain 'timeStamp'")
    require(metrics.value.nonEmpty, "Input metrics data must contain weight 'value'")
    require((Integer.parseInt(metrics.value.get)>0 && Integer.parseInt(metrics.value.get)<500), "Recording Error - Weight must be between 0 and 500 only")
    require(baseWeight.nonEmpty, "Please provide the Baseweight in the request")
    metrics
  }
}

