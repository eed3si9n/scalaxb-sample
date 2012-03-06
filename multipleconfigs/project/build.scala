import sbt._

object Build extends sbt.Build {
  import sbtscalaxb.Plugin._
  import ScalaxbKeys._
  import Keys._

  val Ipo = config("ipo") extend(Compile)
  val W = config("w") extend(Compile)

  lazy val app = Project("app", file("."), settings = appSettings)

  lazy val buildSettings = Defaults.defaultSettings ++ Seq(
    version := "0.1",
    organization := "com.example"
  )

  lazy val appSettings = buildSettings ++ Seq(
    name := "scalaxb-multipleconfigs-sample"
  ) ++ codeGenSettings

  def customScalaxbSettings(base: String): Seq[Project.Setting[_]] = Seq(
    sources <<= xsdSource map { xsd => Seq(xsd / (base + ".xsd")) },
    packageName := base,
    protocolFileName := base + "_xmlprotocol.scala"
  )

  def codeGenSettings: Seq[Project.Setting[_]] =
    inConfig(Ipo)(baseScalaxbSettings ++ inTask(scalaxb)(customScalaxbSettings("ipo"))) ++
    inConfig(W)(baseScalaxbSettings ++ inTask(scalaxb)(customScalaxbSettings("w"))) ++ Seq(
      sourceGenerators in Compile <+= scalaxb in Ipo,
      sourceGenerators in Compile <+= scalaxb in W
    )
}
