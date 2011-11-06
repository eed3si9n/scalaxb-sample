import ScalaxbKeys._

organization := "com.example"

name := "scalaxb-brukersesjon-sample"

seq(scalaxbSettings: _*)

packageName in scalaxb in Compile := "ergogroup"

sourceGenerators in Compile <+= scalaxb in Compile

libraryDependencies += "net.databinder" %% "dispatch-http" % "0.8.5"

sources in scalaxb in Compile <<= (xsdSource in scalaxb in Compile, wsdlSource in scalaxb in Compile) map { (xsd, wsdl) =>
  (wsdl ** "*.wsdl").get ++ (xsd ** "*.xsd").get }

