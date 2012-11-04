object Main extends App {
  val subject = <SomeElement value="bar">foo</SomeElement>
  val x = scalaxb.toXML[generated.SomeElement](scalaxb.fromXML[generated.SomeElement](subject), None, Some("SomeElement"), subject.scope)
  println(x.toString)
}
