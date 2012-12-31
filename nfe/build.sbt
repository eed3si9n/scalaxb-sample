import ScalaxbKeys._

organization := "com.example"

name := "scalaxb-nfe-sample"

scalaVersion := "2.10.0"

scalaxbSettings

// sources in scalaxb in Compile <<= xsdSource in scalaxb in Compile map { xsd => (xsd * "*.xsd").get }

packageName in scalaxb in Compile := "nfe"

packageNames in scalaxb in Compile := Map(
  uri("http://www.portalfiscal.inf.br/nfe/wsdl/NfeConsulta2")      -> "nfe.consulta",
  uri("http://www.portalfiscal.inf.br/nfe/wsdl/NfeStatusServico2") -> "nfe.status",
  uri("http://www.portalfiscal.inf.br/nfe/wsdl/NfeCancelamento2")  -> "nfe.cancelamento",
  uri("http://www.portalfiscal.inf.br/nfe/wsdl/NfeInutilizacao2")  -> "nfe.inutilizacao",
  uri("http://www.portalfiscal.inf.br/nfe/wsdl/NfeRecepcao2")      -> "nfe.recpcao",
  uri("http://www.portalfiscal.inf.br/nfe/wsdl/NfeRetRecepcao2")   -> "nfe.retrecepcao",
  uri("http://www.w3.org/2000/09/xmldsig#")                        -> "xmldsig"
)

protocolPackageName in scalaxb in Compile := Some("nfe")

sourceGenerators in Compile <+= scalaxb in Compile

libraryDependencies += "net.databinder.dispatch" %% "dispatch-core" % "0.9.4"
