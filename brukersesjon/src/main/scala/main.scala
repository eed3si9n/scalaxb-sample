import ergogroup._

object Main extends App {
  val service = (new BrukersesjonBindings with scalaxb.Soap11Clients with scalaxb.DispatchHttpClients).service
  
  // def loggInn(value: ergogroup.LoggInn, transaksjon: ergogroup.Transaksjon): Either[scalaxb.Fault[Feil], LoggInnOutput]
  println(service.loggInn(
    LoggInn(InnloggingSequence(PTP, "x",
      AkkrediteringSequence(scalaxb.DataRecord(None, None, BpSequence("guest", "guest")), None))),
    Transaksjon(None, None, None, None, Map())
  ))  
}
