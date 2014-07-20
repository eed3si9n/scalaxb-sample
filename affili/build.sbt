import ScalaxbKeys._

val scalaXml = "org.scala-lang.modules" %% "scala-xml" % "1.0.2"
val scalaParser = "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.1"
val dispatchV = "0.11.1" // change this to appropriate dispatch version
val dispatch = "net.databinder.dispatch" %% "dispatch-core" % dispatchV

organization := "com.example"

name := "scalaxb-affili-sample"

scalaVersion := "2.11.1"

scalaxbSettings

packageName in (Compile, scalaxb) := "affili"

packageNames in (Compile, scalaxb) := Map(uri("http://schemas.microsoft.com/2003/10/Serialization/") -> "microsoft.serialization")

dispatchVersion in (Compile, scalaxb) := dispatchV
 
async in (Compile, scalaxb) := true

sourceGenerators in Compile <+= scalaxb in Compile

libraryDependencies ++= Seq(scalaXml, scalaParser, dispatch)

logLevel in (Compile, scalaxb) := Level.Debug
