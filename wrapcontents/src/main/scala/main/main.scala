object Main extends App {
  val subject = <shipTo xmlns="http://www.example.com/IPO">
    <name>Foo</name>
    <street>1537 Paper Street</street>
    <city>Wilmington</city>
  </shipTo>
   
  val shipTo = scalaxb.fromXML[ipo.Address](subject)
  println(shipTo.name)
}
