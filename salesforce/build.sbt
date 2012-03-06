import ScalaxbKeys._

organization := "com.example"

name := "scalaxb-salesforce-partner-sample"

seq(scalaxbSettings: _*)

protocolPackageName in scalaxb in Compile := Some("salesforce.binding")

packageName in scalaxb in Compile := "salesforce"

packageNames in scalaxb in Compile := Map(
  uri("https://telemarketing.donotcall.gov/DownloadSvc/") -> "donotcall",
  uri("urn:enterprise.soap.sforce.com") -> "salesforce.enterprise",
  uri("urn:fault.enterprise.soap.sforce.com") -> "salesforce.enterprise.fault",
  uri("urn:partner.soap.sforce.com") -> "salesforce.partner",
  uri("urn:fault.partner.soap.sforce.com") -> "salesforce.partner.fault"
)

sourceGenerators in Compile <+= scalaxb in Compile

libraryDependencies += "net.databinder" %% "dispatch-http" % "0.8.5"
