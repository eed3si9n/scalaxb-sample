object Main extends App {
  val shipto = <shipto xmlns="http://www.example.com/IPO">
      <name>foo</name>
      <street>1537 Paper Street</street>
      <city>Wilmington</city>
      <state>DE</state>
      <zip>19808</zip>
    </shipto>
  println(scalaxb.fromXML[ipo.USAddress](shipto))

  val weather = <weather xmlns="http://www.example.com/weather">
      <zip>19808</zip>
      <status>Sunny</status>
    </weather>
  println(scalaxb.fromXML[w.Weather](weather))
}
