import ScalaxbKeys._

organization := "com.example"

name := "scalaxb-nfe-sample"

seq(scalaxbSettings: _*)

packageName in scalaxb in Compile := "nfe"

packageNames in scalaxb in Compile := Map(
  uri("http://www.portalfiscal.inf.br/nfe/wsdl/NfeConsulta2")      -> "nfe.consulta",
  uri("http://www.portalfiscal.inf.br/nfe/wsdl/NfeStatusServico2") -> "nfe.status",
  uri("http://www.portalfiscal.inf.br/nfe/wsdl/NfeCancelamento2")  -> "nfe.cancelamento",
  uri("http://www.portalfiscal.inf.br/nfe/wsdl/NfeInutilizacao2")  -> "nfe.inutilizacao",
  uri("http://www.portalfiscal.inf.br/nfe/wsdl/NfeRecepcao2")      -> "nfe.recpcao",
  uri("http://www.portalfiscal.inf.br/nfe/wsdl/NfeRetRecepcao2")   -> "nfe.retrecepcao"
)

protocolPackageName in scalaxb in Compile := Some("nfe")

sourceGenerators in Compile <+= scalaxb in Compile

libraryDependencies += "net.databinder" %% "dispatch-http" % "0.8.5"
