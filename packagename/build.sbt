import ScalaxbKeys._

organization := "com.example"

name := "scalaxb-packagename-sample"

seq(scalaxbSettings: _*)

packageName in scalaxb in Compile := "generated"

packageNames in scalaxb in Compile := Map(uri("http://schemas.datacontract.org/Entities") -> "entities")

sourceGenerators in Compile <+= scalaxb in Compile

libraryDependencies += "net.databinder" %% "dispatch-http" % "0.8.5"
