import generated.{InternalAddress, TypedAddress, Address, Customer}

object main extends App {
  val internalAddress = InternalAddress(line1 = "line111", line2 = "line222")
  println(internalAddress)
  
  // this works:
  println(scalaxb.toXML[generated.InternalAddress](internalAddress, None, Some("internalAddress1"), generated.defaultScope))

  val address = Address(scalaxb.DataRecord(None, Some("internalAddress"), internalAddress))
  println(address)
  println(scalaxb.toXML[generated.Address](address, None, Some("address1"), generated.defaultScope))

  val customer = Customer(name = "john", id = "22", address = address)
  println(customer)
  println(scalaxb.toXML[generated.Customer](customer, None, Some("customer1"), generated.defaultScope))

  val address2 = TypedAddress(scalaxb.DataRecord(None, Some("internalAddress"), internalAddress), "Billing")
  val customer2 = Customer(name = "john", id = "22", address = address2)
  println(customer2)
  println(scalaxb.toXML[generated.Customer](customer2, None, Some("customer2"), generated.defaultScope))
}
