name := "SBT Hello Starter"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging" % "3.1.0"

libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.1.6"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.0"

//lazy val teryt = project
//  .in(file("."))
//  .dependsOn(commons)
//
//lazy val commons = ProjectRef(uri("https://github.com/odwrotnie/rzepaw-commons.git#master"), "rzepaw-commons")
