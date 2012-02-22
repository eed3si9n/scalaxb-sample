import ScalaxbKeys._

organization := "com.example"

name := "gh138-sample"

seq(scalaxbSettings: _*)

packageName in scalaxb in Compile := "generated"

sourceGenerators in Compile <+= scalaxb in Compile

// libraryDependencies += "net.databinder" %% "dispatch-http" % "0.8.5"
