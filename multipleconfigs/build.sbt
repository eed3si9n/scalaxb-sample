lazy val Ipo = config("ipo") extend Compile
lazy val W = config("w") extend Compile

lazy val commonSettings = Seq(
  version := "0.1",
  organization := "com.example",
  scalaVersion := "2.11.12"
)

lazy val scalaXml = "org.scala-lang.modules" %% "scala-xml" % "1.1.0"
lazy val scalaParser = "org.scala-lang.modules" %% "scala-parser-combinators" % "1.1.1"

lazy val app = (project in file(".")).
  settings(commonSettings: _*).
  settings(codeGenSettings: _*).
  settings(
    name := "scalaxb-multipleconfigs-sample",
    libraryDependencies ++=
      (if (scalaVersion.value startsWith "2.10") Seq() else
        Seq(scalaXml, scalaParser))
  )

def codeGenSettings: Seq[Def.Setting[_]] =
  inConfig(Ipo)(ScalaxbPlugin.baseScalaxbSettings ++ inTask(scalaxb)(customScalaxbSettings("ipo"))) ++
    inConfig(W)(ScalaxbPlugin.baseScalaxbSettings ++ inTask(scalaxb)(customScalaxbSettings("w"))) ++
    Seq(
      sourceGenerators in Compile += (scalaxb in Ipo).taskValue,
      sourceGenerators in Compile += (scalaxb in W).taskValue,
      // Runtime needs to be generated only once
      scalaxbGenerateRuntime in (Ipo, scalaxb) := true
    )

def customScalaxbSettings(base: String): Seq[Def.Setting[_]] = Seq(
  sourceManaged := (sourceManaged in Compile).value / "sbt-scalaxb" / base,
  scalaxbGenerateRuntime := false,
  sources := Seq(scalaxbXsdSource.value / (base + ".xsd")),
  scalaxbPackageName := base,
  scalaxbProtocolFileName := base + "_xmlprotocol.scala"
)

