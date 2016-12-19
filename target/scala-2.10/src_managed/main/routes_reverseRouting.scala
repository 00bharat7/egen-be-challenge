// @SOURCE:/Users/bharaka/scala-workspace/SearchAndDiscovery/nile-code/bharaka/EgenTest/conf/routes
// @HASH:fff841876bf106c539e78c4bacda7f77f3d92fe6
// @DATE:Sun Dec 18 18:52:48 CST 2016

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset

import Router.queryString


// @LINE:9
// @LINE:6
package controllers {

// @LINE:9
class ReverseAssets {


// @LINE:9
def at(file:String): Call = {
   implicit val _rrc = new ReverseRouteContext(Map(("path", "/public")))
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                        

}
                          

// @LINE:6
class ReverseApplication {


// @LINE:6
def index(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix)
}
                        

}
                          
}
                  

// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
package com.test.weighttracker.controllers {

// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
class ReverseWeightTracker {


// @LINE:13
def fetchMetricsByTimeRange(from:Option[String], to:Option[String]): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "metrics/readByTimeRange" + queryString(List(Some(implicitly[QueryStringBindable[Option[String]]].unbind("from", from)), Some(implicitly[QueryStringBindable[Option[String]]].unbind("to", to)))))
}
                        

// @LINE:12
def fetchMetrics(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "metrics/read")
}
                        

// @LINE:15
def fetchAlertsByTimeRange(from:Option[String], to:Option[String]): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "alerts/readByTimeRange" + queryString(List(Some(implicitly[QueryStringBindable[Option[String]]].unbind("from", from)), Some(implicitly[QueryStringBindable[Option[String]]].unbind("to", to)))))
}
                        

// @LINE:11
def postMetrics(baseWeight:String): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "metrics/create/" + implicitly[PathBindable[String]].unbind("baseWeight", dynamicString(baseWeight)))
}
                        

// @LINE:14
def fetchAlerts(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "alerts/read")
}
                        

}
                          
}
                  


// @LINE:9
// @LINE:6
package controllers.javascript {
import ReverseRouteContext.empty

// @LINE:9
class ReverseAssets {


// @LINE:9
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        

}
              

// @LINE:6
class ReverseApplication {


// @LINE:6
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        

}
              
}
        

// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
package com.test.weighttracker.controllers.javascript {
import ReverseRouteContext.empty

// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
class ReverseWeightTracker {


// @LINE:13
def fetchMetricsByTimeRange : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.test.weighttracker.controllers.WeightTracker.fetchMetricsByTimeRange",
   """
      function(from,to) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "metrics/readByTimeRange" + _qS([(""" + implicitly[QueryStringBindable[Option[String]]].javascriptUnbind + """)("from", from), (""" + implicitly[QueryStringBindable[Option[String]]].javascriptUnbind + """)("to", to)])})
      }
   """
)
                        

// @LINE:12
def fetchMetrics : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.test.weighttracker.controllers.WeightTracker.fetchMetrics",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "metrics/read"})
      }
   """
)
                        

// @LINE:15
def fetchAlertsByTimeRange : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.test.weighttracker.controllers.WeightTracker.fetchAlertsByTimeRange",
   """
      function(from,to) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "alerts/readByTimeRange" + _qS([(""" + implicitly[QueryStringBindable[Option[String]]].javascriptUnbind + """)("from", from), (""" + implicitly[QueryStringBindable[Option[String]]].javascriptUnbind + """)("to", to)])})
      }
   """
)
                        

// @LINE:11
def postMetrics : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.test.weighttracker.controllers.WeightTracker.postMetrics",
   """
      function(baseWeight) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "metrics/create/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("baseWeight", encodeURIComponent(baseWeight))})
      }
   """
)
                        

// @LINE:14
def fetchAlerts : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.test.weighttracker.controllers.WeightTracker.fetchAlerts",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "alerts/read"})
      }
   """
)
                        

}
              
}
        


// @LINE:9
// @LINE:6
package controllers.ref {


// @LINE:9
class ReverseAssets {


// @LINE:9
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      

}
                          

// @LINE:6
class ReverseApplication {


// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      

}
                          
}
        

// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
package com.test.weighttracker.controllers.ref {


// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
class ReverseWeightTracker {


// @LINE:13
def fetchMetricsByTimeRange(from:Option[String], to:Option[String]): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.test.weighttracker.controllers.WeightTracker.fetchMetricsByTimeRange(from, to), HandlerDef(this.getClass.getClassLoader, "", "com.test.weighttracker.controllers.WeightTracker", "fetchMetricsByTimeRange", Seq(classOf[Option[String]], classOf[Option[String]]), "GET", """""", _prefix + """metrics/readByTimeRange""")
)
                      

// @LINE:12
def fetchMetrics(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.test.weighttracker.controllers.WeightTracker.fetchMetrics(), HandlerDef(this.getClass.getClassLoader, "", "com.test.weighttracker.controllers.WeightTracker", "fetchMetrics", Seq(), "GET", """""", _prefix + """metrics/read""")
)
                      

// @LINE:15
def fetchAlertsByTimeRange(from:Option[String], to:Option[String]): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.test.weighttracker.controllers.WeightTracker.fetchAlertsByTimeRange(from, to), HandlerDef(this.getClass.getClassLoader, "", "com.test.weighttracker.controllers.WeightTracker", "fetchAlertsByTimeRange", Seq(classOf[Option[String]], classOf[Option[String]]), "GET", """""", _prefix + """alerts/readByTimeRange""")
)
                      

// @LINE:11
def postMetrics(baseWeight:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.test.weighttracker.controllers.WeightTracker.postMetrics(baseWeight), HandlerDef(this.getClass.getClassLoader, "", "com.test.weighttracker.controllers.WeightTracker", "postMetrics", Seq(classOf[String]), "POST", """""", _prefix + """metrics/create/$baseWeight<[^/]+>""")
)
                      

// @LINE:14
def fetchAlerts(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.test.weighttracker.controllers.WeightTracker.fetchAlerts(), HandlerDef(this.getClass.getClassLoader, "", "com.test.weighttracker.controllers.WeightTracker", "fetchAlerts", Seq(), "GET", """""", _prefix + """alerts/read""")
)
                      

}
                          
}
        
    