
/*
def core_getPollsByDeviceId(deviceId: BigInt): Either[scalaxb.Fault[Any], ArrayOfSO_Poll] = 
  soapClient.requestResponse(scala.xml.Elem(targetNamespace map {defaultScope.getPrefix(_)} getOrElse {""}, "core_getPollsByDeviceId", scala.xml.Null, defaultScope,
    scalaxb.toXML(deviceId, Some("http://www.sevone.com/"), "deviceId", defaultScope): _*), defaultScope, baseAddress, "POST", Some(new java.net.URI("urn:SevOneApi#SevOneApiServer#core_getPollsByDeviceId"))) match {
    case Left(x)  => Left(x)
    case Right(x) => Right(scalaxb.fromXML[ArrayOfSO_Poll]((x.head \ "return").head))
  }
*/  
object Main extends App {
  val x = <ns1:core_getEnabledPluginsByDeviceIdResponse
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:SOAP-ENC="http://schemas.xmlsoap.org/soap/encoding/"
    xmlns:xsd="http://www.w3.org/2001/XMLSchema"
    xmlns:ns1="http://www.sevone.com/"
    xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/"><return
          xsi:type="ns1:ArrayOfstring" SOAP-ENC:arrayType="xsd:string[15]"><item
          xsi:type="xsd:string">BULKDATA</item><item
          xsi:type="xsd:string">CALLMANAGER</item><item
          xsi:type="xsd:string">DEFERRED</item><item
          xsi:type="xsd:string">DNS</item><item xsi:type="xsd:string">HTTP</item><item
          xsi:type="xsd:string">ICMP</item><item
          xsi:type="xsd:string">IPSLA</item><item
          xsi:type="xsd:string">MYSQLDB</item><item
          xsi:type="xsd:string">NBAR</item><item
          xsi:type="xsd:string">PORTSHAKER</item><item
          xsi:type="xsd:string">PROCESS</item><item
          xsi:type="xsd:string">PROXYPING</item><item
          xsi:type="xsd:string">SNMP</item><item
          xsi:type="xsd:string">WEBSTATUS</item><item
          xsi:type="xsd:string">WMI</item></return></ns1:core_getEnabledPluginsByDeviceIdResponse>  
  
   val plugin = Right(scalaxb.fromXML[sevone.ArrayOfSO_Poll]((x.head \ "return").head))
   println(plugin)
}
