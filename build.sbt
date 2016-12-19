
name := "EgenTest"

version := "1.0"

lazy val `egentest` = (project in file(".")).enablePlugins(PlayScala).settings(libraryDependencies ~= (_.map(excludeSpecs2)))

scalaVersion := "2.10.5"

libraryDependencies ++= Seq( jdbc , cache , ws  , anorm,
  "org.mongodb" %% "casbah" % "2.5.0",
  "net.liftweb" %% "lift-json-ext" % "2.6.+",
  "org.scalatest" % "scalatest_2.10" % "2.1.3" % "test",
  "de.flapdoodle.embed" % "de.flapdoodle.embed.mongo" % "1.45")

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )

// tests won't run after update to Play 2.3 without this exclusion
def excludeSpecs2(module: ModuleID): ModuleID =
  module.excludeAll(ExclusionRule(organization = "org.specs2"))
