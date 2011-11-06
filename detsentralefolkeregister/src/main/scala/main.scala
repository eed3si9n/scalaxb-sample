import ergogroup._

object Main extends App {
  val service = (new DsfBindings with scalaxb.Soap11Clients with scalaxb.DispatchHttpClients).service
  println(service.hentHistorikk(None, None, None, None))
}
