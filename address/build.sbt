import ScalaxbKeys._

organization := "com.example"

name := "scalaxb-address-sample"

seq(scalaxbSettings: _*)

packageName in scalaxb in Compile := "generated"

sourceGenerators in Compile <+= (scalaxb in Compile).identity

// libraryDependencies += "net.databinder" %% "dispatch-http" % "0.8.5"
