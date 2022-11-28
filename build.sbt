
ThisBuild / name := "Schedule-Solver"
ThisBuild / scalaVersion := "3.2.1"
ThisBuild / organization := "com.palmer.data"
ThisBuild / version      := "0.0.1"

libraryDependencies ++= Seq(
  "org.scalactic" %% "scalactic" % "3.2.14",
  "org.scalatest" %% "scalatest" % "3.2.14" % "test",
  "com.google.ortools" % "ortools-java" % "9.4.1874"
)