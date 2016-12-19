package com.test.weighttracker.manager

import com.mongodb.casbah.Imports._
import com.sun.media.sound.InvalidDataException
import com.test.weighttracker.connection.MongoFactory
import com.test.weighttracker.model.{AlertRequest, MetricRequest}
import net.liftweb.json.DefaultFormats

import scala.concurrent.Future
import scala.util.{Failure, Success, Try}

/**
  * Created by bharaka on 12/17/16.
  */
object WeightTrackManager extends WeightTrackManager

trait WeightTrackManager {
  implicit val formats = DefaultFormats

  def processSave(metrics: MetricRequest,baseWeight:String): Future[Try[String]] = {
    // save to database and return message
    val postResult: Try[String] = saveToMongo(metrics,baseWeight)
    postResult match {
      case Success(s) => Future.successful(Success(s))
      case Failure(postError) => Future.successful(Failure(postError))
    }
  }

  def saveToMongo(metrics:MetricRequest,base_weight:String): Try[String] = {
    try{
      val alert=checkAlert(metrics.value.get,base_weight)
      metrics.value match {
        case Some(`base_weight`) => MongoFactory.collection1.save(DBObject("timeStamp"->metrics.timeStamp,"value"->metrics.value))
        case _     =>
          MongoFactory.collection1.save(DBObject("timeStamp"->metrics.timeStamp,"value"->metrics.value))
          if(alert!=None)
            MongoFactory.collection2.save(DBObject("timeStamp"->metrics.timeStamp,"value"->metrics.value,"alert"->alert.get))
      }
      val successMsg = s"Successfully added weight - ${metrics.value.get}"
      Success(successMsg)
    }catch{
      case e: Exception =>
        val errorMsg = s"Failed to post metrics payload - $metrics"
        Failure(new Exception(errorMsg))
    }
  }

  def fetchMetrics :Future[Either[Exception, List[MetricRequest]]]={
    val metrics=MongoFactory.collection1.find.map({o=>
      MetricRequest(Some(o.asInstanceOf[BasicDBObject].as[String]("timeStamp")),Some(o.asInstanceOf[BasicDBObject].as[String]("value")))
    }).toList
    val response=if(metrics.size==0) Left(new InvalidDataException("No Metrics available")) else Right(metrics)
    Future.successful(response)
  }

  def fetchMetricsByTimeRange(min:Option[String],max:Option[String]) :Future[Either[Exception, List[MetricRequest]]]={
    val dbObject=buildQuery(min,max)
    val metrics=MongoFactory.collection1.find(dbObject).map({o=>
      MetricRequest(Some(o.asInstanceOf[BasicDBObject].as[String]("timeStamp")),Some(o.asInstanceOf[BasicDBObject].as[String]("value")))
    }).toList
    val response=if(metrics.size==0) Left(new InvalidDataException("No Metrics available in the Time Range")) else Right(metrics)
    Future.successful(response)
  }

  def fetchAlerts :Future[Either[Exception, List[AlertRequest]]]={
    val metrics=MongoFactory.collection2.find.map({o=>
      AlertRequest(o.asInstanceOf[BasicDBObject].as[String]("timeStamp"),o.asInstanceOf[BasicDBObject].as[String]("value"),
        o.asInstanceOf[BasicDBObject].as[String]("alert"))
    }).toList
    val response=if(metrics.size==0) Left(new InvalidDataException("No Metrics available")) else Right(metrics)
    Future.successful(response)
  }

  def fetchAlertsByTimeRange(min:Option[String],max:Option[String]) :Future[Either[Exception, List[AlertRequest]]]={
    val dbObject=buildQuery(min,max)
    val metrics=MongoFactory.collection2.find(dbObject).map({o=>
      AlertRequest(o.asInstanceOf[BasicDBObject].as[String]("timeStamp"),o.asInstanceOf[BasicDBObject].as[String]("value"),
        o.asInstanceOf[BasicDBObject].as[String]("alert"))
    }).toList
    val response=if(metrics.size==0) Left(new InvalidDataException("No Metrics available in the Time Range")) else Right(metrics)
    Future.successful(response)
  }

  def checkAlert(weight:String,base_weight:String) : Option[String] ={
    val recordedWeight=Integer.parseInt(weight)
    val recordedBaseWeight=Integer.parseInt(base_weight)
    if((recordedWeight-recordedBaseWeight) > recordedBaseWeight/10)
      Some("Weight above 10% - Check your calories")
    else if((recordedBaseWeight-recordedWeight) > recordedBaseWeight/10)
      Some("Weight below 10% - Eat well")
    else
      None
  }

  def buildQuery(min:Option[String],max:Option[String])={
    DBObject("timeStamp"-> MongoDBObject("$gte" -> min, "$lte" -> max))
  }
}
