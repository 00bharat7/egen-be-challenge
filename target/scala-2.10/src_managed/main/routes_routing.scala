// @SOURCE:/Users/bharaka/scala-workspace/SearchAndDiscovery/nile-code/bharaka/EgenTest/conf/routes
// @HASH:fff841876bf106c539e78c4bacda7f77f3d92fe6
// @DATE:Sun Dec 18 18:52:48 CST 2016


import scala.language.reflectiveCalls
import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset

import Router.queryString

object Routes extends Router.Routes {

import ReverseRouteContext.empty

private var _prefix = "/"

def setPrefix(prefix: String): Unit = {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:6
private[this] lazy val controllers_Application_index0_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
private[this] lazy val controllers_Application_index0_invoker = createInvoker(
controllers.Application.index,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "index", Nil,"GET", """ Home page""", Routes.prefix + """"""))
        

// @LINE:9
private[this] lazy val controllers_Assets_at1_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
private[this] lazy val controllers_Assets_at1_invoker = createInvoker(
controllers.Assets.at(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
        

// @LINE:11
private[this] lazy val com_test_weighttracker_controllers_WeightTracker_postMetrics2_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("metrics/create/"),DynamicPart("baseWeight", """[^/]+""",true))))
private[this] lazy val com_test_weighttracker_controllers_WeightTracker_postMetrics2_invoker = createInvoker(
com.test.weighttracker.controllers.WeightTracker.postMetrics(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "com.test.weighttracker.controllers.WeightTracker", "postMetrics", Seq(classOf[String]),"POST", """""", Routes.prefix + """metrics/create/$baseWeight<[^/]+>"""))
        

// @LINE:12
private[this] lazy val com_test_weighttracker_controllers_WeightTracker_fetchMetrics3_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("metrics/read"))))
private[this] lazy val com_test_weighttracker_controllers_WeightTracker_fetchMetrics3_invoker = createInvoker(
com.test.weighttracker.controllers.WeightTracker.fetchMetrics,
HandlerDef(this.getClass.getClassLoader, "", "com.test.weighttracker.controllers.WeightTracker", "fetchMetrics", Nil,"GET", """""", Routes.prefix + """metrics/read"""))
        

// @LINE:13
private[this] lazy val com_test_weighttracker_controllers_WeightTracker_fetchMetricsByTimeRange4_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("metrics/readByTimeRange"))))
private[this] lazy val com_test_weighttracker_controllers_WeightTracker_fetchMetricsByTimeRange4_invoker = createInvoker(
com.test.weighttracker.controllers.WeightTracker.fetchMetricsByTimeRange(fakeValue[Option[String]], fakeValue[Option[String]]),
HandlerDef(this.getClass.getClassLoader, "", "com.test.weighttracker.controllers.WeightTracker", "fetchMetricsByTimeRange", Seq(classOf[Option[String]], classOf[Option[String]]),"GET", """""", Routes.prefix + """metrics/readByTimeRange"""))
        

// @LINE:14
private[this] lazy val com_test_weighttracker_controllers_WeightTracker_fetchAlerts5_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("alerts/read"))))
private[this] lazy val com_test_weighttracker_controllers_WeightTracker_fetchAlerts5_invoker = createInvoker(
com.test.weighttracker.controllers.WeightTracker.fetchAlerts,
HandlerDef(this.getClass.getClassLoader, "", "com.test.weighttracker.controllers.WeightTracker", "fetchAlerts", Nil,"GET", """""", Routes.prefix + """alerts/read"""))
        

// @LINE:15
private[this] lazy val com_test_weighttracker_controllers_WeightTracker_fetchAlertsByTimeRange6_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("alerts/readByTimeRange"))))
private[this] lazy val com_test_weighttracker_controllers_WeightTracker_fetchAlertsByTimeRange6_invoker = createInvoker(
com.test.weighttracker.controllers.WeightTracker.fetchAlertsByTimeRange(fakeValue[Option[String]], fakeValue[Option[String]]),
HandlerDef(this.getClass.getClassLoader, "", "com.test.weighttracker.controllers.WeightTracker", "fetchAlertsByTimeRange", Seq(classOf[Option[String]], classOf[Option[String]]),"GET", """""", Routes.prefix + """alerts/readByTimeRange"""))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """metrics/create/$baseWeight<[^/]+>""","""com.test.weighttracker.controllers.WeightTracker.postMetrics(baseWeight:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """metrics/read""","""com.test.weighttracker.controllers.WeightTracker.fetchMetrics"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """metrics/readByTimeRange""","""com.test.weighttracker.controllers.WeightTracker.fetchMetricsByTimeRange(from:Option[String], to:Option[String])"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """alerts/read""","""com.test.weighttracker.controllers.WeightTracker.fetchAlerts"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """alerts/readByTimeRange""","""com.test.weighttracker.controllers.WeightTracker.fetchAlertsByTimeRange(from:Option[String], to:Option[String])""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]]
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_Application_index0_route(params) => {
   call { 
        controllers_Application_index0_invoker.call(controllers.Application.index)
   }
}
        

// @LINE:9
case controllers_Assets_at1_route(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at1_invoker.call(controllers.Assets.at(path, file))
   }
}
        

// @LINE:11
case com_test_weighttracker_controllers_WeightTracker_postMetrics2_route(params) => {
   call(params.fromPath[String]("baseWeight", None)) { (baseWeight) =>
        com_test_weighttracker_controllers_WeightTracker_postMetrics2_invoker.call(com.test.weighttracker.controllers.WeightTracker.postMetrics(baseWeight))
   }
}
        

// @LINE:12
case com_test_weighttracker_controllers_WeightTracker_fetchMetrics3_route(params) => {
   call { 
        com_test_weighttracker_controllers_WeightTracker_fetchMetrics3_invoker.call(com.test.weighttracker.controllers.WeightTracker.fetchMetrics)
   }
}
        

// @LINE:13
case com_test_weighttracker_controllers_WeightTracker_fetchMetricsByTimeRange4_route(params) => {
   call(params.fromQuery[Option[String]]("from", None), params.fromQuery[Option[String]]("to", None)) { (from, to) =>
        com_test_weighttracker_controllers_WeightTracker_fetchMetricsByTimeRange4_invoker.call(com.test.weighttracker.controllers.WeightTracker.fetchMetricsByTimeRange(from, to))
   }
}
        

// @LINE:14
case com_test_weighttracker_controllers_WeightTracker_fetchAlerts5_route(params) => {
   call { 
        com_test_weighttracker_controllers_WeightTracker_fetchAlerts5_invoker.call(com.test.weighttracker.controllers.WeightTracker.fetchAlerts)
   }
}
        

// @LINE:15
case com_test_weighttracker_controllers_WeightTracker_fetchAlertsByTimeRange6_route(params) => {
   call(params.fromQuery[Option[String]]("from", None), params.fromQuery[Option[String]]("to", None)) { (from, to) =>
        com_test_weighttracker_controllers_WeightTracker_fetchAlertsByTimeRange6_invoker.call(com.test.weighttracker.controllers.WeightTracker.fetchAlertsByTimeRange(from, to))
   }
}
        
}

}
     