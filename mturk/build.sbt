import ScalaxbKeys._

organization := "com.example"

name := "scalaxb-mturk-sample"

scalaVersion := "2.10.3"

scalaxbSettings

packageName in scalaxb in Compile := "mturk"

sourceGenerators in Compile <+= scalaxb in Compile

libraryDependencies += "net.databinder.dispatch" %% "dispatch-core" % "0.11.1"

dispatchVersion in scalaxb in Compile := "0.11.1"
