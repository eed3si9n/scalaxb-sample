object Main extends App {
  import soapenvelope12.{Fault => _, _}
  val bindings = (new nfe.NfeStatusServico2Soap12Bindings with scalaxb.SoapClients with scalaxb.DispatchHttpClients {})
  val service = bindings.service

  // value: nfe.NfeDadosMsg, nfeCabecMsg: nfe.NfeCabecMsg
  // println(service.nfeStatusServicoNF2(nfe.status.NfeDadosMsg(), nfe.status.NfeCabecMsg(None, None, Map())))

  val response =
    <soap:Envelope xmlns:soap="http://www.w3.org/2003/05/soap-envelope"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xmlns:xsd="http://www.w3.org/2001/XMLSchema">
      <soap:Header>
        <nfeCabecMsg xmlns="http://www.portalfiscal.inf.br/nfe/wsdl/NfeStatusServico2">
         <cUF>35</cUF>
         <versaoDados>2.00</versaoDados>
        </nfeCabecMsg>
        <something></something>
      </soap:Header>
      <soap:Body>
        <nfeStatusServicoNF2Result xmlns="http://www.portalfiscal.inf.br/nfe/wsdl/NfeStatusServico2">
          <retConsStatServ versao="2.00" xmlns="http://www.portalfiscal.inf.br/nfe">
            <tpAmb>2</tpAmb>
            <verAplic>SP_NFE_PL_006j</verAplic>
            <cStat>252</cStat>
            <xMotivo>Rejeio: Ambiente informado diverge do Ambiente de recebimento</xMotivo>
            <cUF>35</cUF>
            <dhRecbto>2012-03-24T17:05:03</dhRecbto>
          </retConsStatServ>
        </nfeStatusServicoNF2Result>
      </soap:Body>
    </soap:Envelope>

  val envelope = scalaxb.fromXML[Envelope](response)
  val out = bindings.soapClient.buildResponse(envelope) match {
    case Right((header, body)) =>
            Right(nfe.status.NfeStatusServicoNF2Output(scalaxb.fromXML[nfe.status.NfeStatusServicoNF2Result](body.headOption getOrElse {body}),
              scalaxb.fromXML[nfe.status.NfeCabecMsg]((<x>{header}</x> \ "nfeCabecMsg").head)))
  }

  println(out)
}
