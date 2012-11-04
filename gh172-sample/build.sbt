import ScalaxbKeys._

organization := "com.example"

name := "scalaxb-gh172-sample"

scalaxbSettings

packageName in scalaxb in Compile := "generated"

attributePrefix in scalaxb in Compile := Some("attr")

sourceGenerators in Compile <+= scalaxb in Compile
