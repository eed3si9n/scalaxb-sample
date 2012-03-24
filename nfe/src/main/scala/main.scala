object Main extends App {
  val service = (new nfe.NfeStatusServico2Soap12Bindings with scalaxb.SoapClients with scalaxb.DispatchHttpClients {}).service

  // value: nfe.NfeDadosMsg, nfeCabecMsg: nfe.NfeCabecMsg
  println(service.nfeStatusServicoNF2(nfe.NfeDadosMsg(), nfe.NfeCabecMsg(None, None, Map())))
}
