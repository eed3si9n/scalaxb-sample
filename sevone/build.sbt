import ScalaxbKeys._

organization := "com.example"

name := "scalaxb-sevone-sample"

seq(scalaxbSettings: _*)

packageName in scalaxb in Compile := "sevone"

// sourceGenerators in Compile <+= scalaxb in Compile

unmanagedSourceDirectories in Compile <+= (target) { dir => dir / "scala-2.9.1" / "src_managed" / "main" }

libraryDependencies += "net.databinder" %% "dispatch-http" % "0.8.5"


