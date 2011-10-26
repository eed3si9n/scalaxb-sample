import ScalaxbKeys._

organization := "com.example"

name := "scalaxb-affili-sample"

seq(scalaxbSettings: _*)

packageName in scalaxb in Compile := "affili"

packageNames in scalaxb in Compile := Map(uri("http://schemas.microsoft.com/2003/10/Serialization/") -> "microsoft.serialization")

sourceGenerators in Compile <+= scalaxb in Compile

libraryDependencies += "net.databinder" %% "dispatch-http" % "0.8.5"

// logLevel in scalaxb in Compile := Level.Debug
