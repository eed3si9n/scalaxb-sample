import ScalaxbKeys._

organization := "com.example"

name := "scalaxb-confluence-sample"

seq(scalaxbSettings: _*)

packageName in scalaxb in Compile := "confluence"

packageNames in scalaxb in Compile := Map(
  uri("http://schemas.xmlsoap.org/soap/encoding/") -> "encoding",
  uri("http://wiki.jfrog.org/confluence/rpc/soap-axis/confluenceservice-v1") -> "confluence"
)

sourceGenerators in Compile <+= scalaxb in Compile

libraryDependencies += "net.databinder" %% "dispatch-http" % "0.8.5"
