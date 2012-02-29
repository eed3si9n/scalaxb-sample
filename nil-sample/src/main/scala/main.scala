object Main extends App {
  println(scalaxb.fromXML[generated.USAddress](
    <address
        xmlns:ipo="http://www.example.com/IPO"
        xmlns="http://www.example.com/IPO"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
      <name>Name</name>
      <street>Street</street>
      <city>City</city>
      <state>NJ</state>
      <zip xsi:nil="true" />
    </address>
  ))
}
