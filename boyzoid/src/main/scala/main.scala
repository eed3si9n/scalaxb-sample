object Main extends App {
  val service = (new boyzoid.RandomQuotecfcSoapBindings
    with scalaxb.Soap11Clients with scalaxb.DispatchHttpClients {}).service
  println(service.getAllQuotes)
}
