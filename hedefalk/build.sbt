import ScalaxbKeys._

organization := "com.example"

name := "scalaxb-hedefalk-sample"

seq(scalaxbSettings: _*)

packageName in scalaxb in Compile := "dfk.ka.generated"

packageNames in scalaxb in Compile := Map(
  uri("http://www.hedefalk.se/test") -> "se.hedefalk.test",
  uri("http://www.example.com/data") -> "se.hedefalk.test")

sourceGenerators in Compile <+= scalaxb in Compile

libraryDependencies += "net.databinder" %% "dispatch-http" % "0.8.5"
