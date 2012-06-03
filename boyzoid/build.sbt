import ScalaxbKeys._

organization := "com.example"

name := "scalaxb-boyzoid-sample"

seq(scalaxbSettings: _*)

packageName in scalaxb in Compile := "boyzoid"

packageNames in scalaxb in Compile := Map(
  uri("http://schemas.xmlsoap.org/soap/encoding/") -> "soapenc",
  uri("http://rpc.xml.coldfusion") -> "coldfusion",
  uri("http://xml.apache.org/xml-soap") -> "xmlsoap"
)

sourceGenerators in Compile <+= scalaxb in Compile

libraryDependencies += "net.databinder" %% "dispatch-http" % "0.8.5"
