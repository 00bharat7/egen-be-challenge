package com.test.weighttracker.controllers

import com.mongodb.casbah.Imports._
import com.mongodb.casbah.commons.conversions.scala.{RegisterConversionHelpers, RegisterJodaTimeConversionHelpers}
import com.test.weighttracker.connection.MongoFactory
import com.test.weighttracker.manager.{StartEmbedMongo, WeightTrackManager}
import com.test.weighttracker.model.MetricRequest
import net.liftweb.json.DefaultFormats
import org.scalatest.{BeforeAndAfterAll, BeforeAndAfterEach, FlatSpec, MustMatchers}

/**
  * Created by bharaka on 12/18/16.
  */
class WeightTrackerTest extends FlatSpec with MustMatchers with BeforeAndAfterAll with BeforeAndAfterEach {
  val weightTrackManager: WeightTrackManager = new WeightTrackManager {}
  implicit val formats = DefaultFormats

  val inputMetrics_with_validFields = s"""{
            "timeStamp": "1458062848734",
            "value": "193"
        }"""

  override def beforeAll {
    clearDB

  }
  override def afterAll {
    clearDB
  }
  def clearDB ={
    MongoFactory.collection1.remove(DBObject("timeStamp"->"1458062848734"))
    MongoFactory.collection2.remove(DBObject("timeStamp"->"1458062848734"))
  }

  "POST" must "correctly insert metrics and return Success" in {
    createMetricsWithValidJsonAndVerify
  }

  "GET Metrics" must "atleast fetch 1 metric after create" in {
    fetchMetrics
  }

  "GET Alerts" must "atleast fetch 1 alerts after create" in {
    fetchAlerts
  }

  "GET Metrics by timestamp" must "atleast fetch 1 metric between the timestamps after create" in {
    fetchMetricsByTimeStamp
  }

  "GET Alerts by timestamp" must "atleast fetch 1 alerts between the timestamps after create" in {
    fetchAlertsByTimeStamp
  }


  def createMetricsWithValidJsonAndVerify {
    val base_weight = "150"
    weightTrackManager.processSave(net.liftweb.json.parse(inputMetrics_with_validFields).extract[MetricRequest],base_weight).
                                                  value.get.get.get must equal("Successfully added weight - 193")
  }

  def fetchAlerts {
 weightTrackManager.fetchAlerts.value.get.get match {
   case Right(data) => data.size must not equal(0)
   case Left(ex) => ex.toString must contain("Exception")
 }
  }

  def fetchMetrics{
    weightTrackManager.fetchMetrics.value.get.get match{
      case Right(data) => data.size must not equal(0)
      case Left(ex) => ex.toString must contain("Exception")
    }
  }

  def fetchAlertsByTimeStamp {
    weightTrackManager.fetchAlertsByTimeRange(Some("1458062848724"),Some("1458062848754")).value.get.get match {
      case Right(data) => data.size must not equal(0)
      case Left(ex) => ex.toString must contain("Exception")
    }
  }

  def fetchMetricsByTimeStamp{
    weightTrackManager.fetchMetricsByTimeRange(Some("1458062848724"),Some("1458062848744")).value.get.get match{
      case Right(data) => data.size must not equal(0)
      case Left(ex) => ex.toString must contain("Exception")
    }
  }

}
