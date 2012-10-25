import ScalaxbKeys._

organization := "com.example"

name := "scalaxb-wrapcontents-sample"

scalaxbSettings

packageName in scalaxb in Compile := "ipo"

wrapContents in scalaxb in Compile += "{http://www.example.com/IPO}Address"

sourceGenerators in Compile <+= scalaxb in Compile
