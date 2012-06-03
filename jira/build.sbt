import ScalaxbKeys._

organization := "com.example"

name := "scalaxb-jira-sample"

seq(scalaxbSettings: _*)

packageName in scalaxb in Compile := "jira"

packageNames in scalaxb in Compile := Map(
  uri("http://schemas.xmlsoap.org/soap/encoding/") -> "soapenc"
)

sourceGenerators in Compile <+= scalaxb in Compile

libraryDependencies += "net.databinder" %% "dispatch-http" % "0.8.5"
