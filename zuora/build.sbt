import ScalaxbKeys._

organization := "com.example"

name := "scalaxb-zuora-sample"

scalaVersion := "2.11.1"

scalaxbSettings

packageName in scalaxb in Compile := "zuora"

sourceGenerators in Compile <+= scalaxb in Compile

val scalaXml = "org.scala-lang.modules" %% "scala-xml" % "1.0.2"
val scalaParser = "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.1"
val dispatch = "net.databinder.dispatch" %% "dispatch-core" % "0.11.1"

libraryDependencies ++= Seq(scalaXml, scalaParser, dispatch)

dispatchVersion in scalaxb in Compile := "0.11.1"
