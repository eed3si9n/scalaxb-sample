import ScalaxbKeys._

organization := "com.example"

name := "scalaxb-crossref-sample"

scalaxbSettings

packageName in scalaxb in Compile := "crossref"

sourceGenerators in Compile <+= scalaxb in Compile

// libraryDependencies += "net.databinder" %% "dispatch-http" % "0.9.4"
