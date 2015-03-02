import ScalaxbKeys._

val scalaXml = "org.scala-lang.modules" %% "scala-xml" % "1.0.2"
val scalaParser = "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.1"
val dispatchV = "0.11.1" // change this to appropriate dispatch version
val dispatch = "net.databinder.dispatch" %% "dispatch-core" % dispatchV
 
lazy val commonSettings = Seq(
  organization := "com.example",
  scalaVersion := "2.11.5"
)

lazy val root = (project in file(".")).
  settings(commonSettings ++ scalaxbSettings: _*).
  settings(
    name := "scalaxb-jira-sample",
    packageName in scalaxb in Compile := "jira",
    packageNames in scalaxb in Compile := Map(
      uri("http://schemas.xmlsoap.org/soap/encoding/") -> "soapenc"
    ),
    dispatchVersion in (Compile, scalaxb) := dispatchV,
    async in (Compile, scalaxb) := true,
    sourceGenerators in Compile <+= scalaxb in Compile,
    libraryDependencies ++= Seq(dispatch, scalaParser, scalaXml)
  )
