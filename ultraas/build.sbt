import ScalaxbKeys._

organization := "com.example"

name := "scalaxb-ultraas-sample"

scalaVersion := "2.10.1"

scalaxbSettings

packageName in scalaxb in Compile := "ultraas"

sourceGenerators in Compile <+= scalaxb in Compile

// libraryDependencies += "net.databinder.dispatch" %% "dispatch-core" % "0.9.5"
