import ScalaxbKeys._

organization := "com.example"

name := "scalaxb-opentravel-sample"

seq(scalaxbSettings: _*)

packageName in scalaxb in Compile := "opentravel"

sourceGenerators in Compile <+= scalaxb in Compile

// libraryDependencies += "net.databinder" %% "dispatch-http" % "0.9.4"
