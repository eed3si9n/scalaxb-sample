import sbtscalaxb.Plugin._
import ScalaxbKeys._

val Ipo = config("ipo") extend(Compile)
val W = config("w") extend(Compile)

lazy val commonSettings = Seq(
  version := "0.1",
  organization := "com.example",
  scalaVersion := "2.11.5"
)

lazy val scalaXml = "org.scala-lang.modules" %% "scala-xml" % "1.0.2"
lazy val scalaParser = "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.1"

lazy val app = (project in file(".")).
  settings(commonSettings: _*).
  settings(codeGenSettings: _*).
  settings(
    name := "scalaxb-multipleconfigs-sample",
    libraryDependencies ++= Seq(scalaXml, scalaParser)
  )

def codeGenSettings: Seq[Def.Setting[_]] =
  inConfig(Ipo)(baseScalaxbSettings ++ inTask(scalaxb)(customScalaxbSettings("ipo"))) ++
  inConfig(W)(baseScalaxbSettings ++ inTask(scalaxb)(customScalaxbSettings("w"))) ++
  Seq(
    sourceGenerators in Compile += (scalaxb in Ipo).taskValue,
    sourceGenerators in Compile += (scalaxb in W).taskValue,
    // Runtime needs to be generated only once
    generateRuntime in (Ipo, scalaxb) := true
  )

def customScalaxbSettings(base: String): Seq[Def.Setting[_]] = Seq(
  sourceManaged := (sourceManaged in Compile).value / "sbt-scalaxb" / base,
  generateRuntime := false,
  sources := Seq(xsdSource.value / (base + ".xsd")),
  packageName := base,
  protocolFileName := base + "_xmlprotocol.scala"
)
