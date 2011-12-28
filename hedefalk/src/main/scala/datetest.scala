object DateTest extends App {
  import javax.xml.datatype.{DatatypeFactory, XMLGregorianCalendar}
  
  val date = se.hedefalk.test.Element1(DatatypeFactory.newInstance().newXMLGregorianCalendarDate(2012, 02, 17, 0))
  
  def testDefault() {
    val s = scalaxb.toXML(date, "element1", scalaxb.toScope())
    println(s)
  }
  
  def testCusomization() {
    val xmlprotocol = new se.hedefalk.test.XMLProtocol {
      override lazy val __CalendarXMLFormat: scalaxb.XMLFormat[XMLGregorianCalendar] = new scalaxb.XMLFormat[XMLGregorianCalendar] {
        import scalaxb._
        def reads(seq: scala.xml.NodeSeq, stack: List[ElemName]): Either[String, XMLGregorianCalendar] = try {
          Right(XMLCalendar(seq.text)) } catch { case e: Exception => Left(e.toString) }

        def writes(obj: XMLGregorianCalendar, namespace: Option[String], elementLabel: Option[String],
            scope: scala.xml.NamespaceBinding, typeAttribute: Boolean): scala.xml.NodeSeq =
          Helper.stringToXML(obj.toXMLFormat + "foo", namespace, elementLabel, scope)
      }
    }
    import xmlprotocol._
    
    val s = scalaxb.toXML(date, "element1", scalaxb.toScope())
    println(s)
  }
  
  
  testDefault()
  testCusomization()
}
