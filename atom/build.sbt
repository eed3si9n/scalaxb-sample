lazy val scalaXml = "org.scala-lang.modules" %% "scala-xml" % "1.0.6"
lazy val scalaParser = "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.5"
lazy val dispatchV = "0.12.0"
lazy val dispatch = "net.databinder.dispatch" %% "dispatch-core" % dispatchV

lazy val root = (project in file(".")).
  enablePlugins(ScalaxbPlugin).
  settings(inThisBuild(List(
    organization  := "com.example",
    scalaVersion  := "2.12.1"
  ))).
  settings(
    name          := "atom",
    libraryDependencies ++= Seq(dispatch),
    libraryDependencies ++= {
      if (scalaVersion.value startsWith "2.10") Seq()
      else Seq(scalaXml, scalaParser)
    }).
  settings(
    scalaxbDispatchVersion in (Compile, scalaxb) := dispatchV,
    scalaxbPackageName in (Compile, scalaxb)     := "org.w3.atom"
    // scalaxbPackageNames in (Compile, scalaxb)    := Map(uri("http://schemas.microsoft.com/2003/10/Serialization/") -> "microsoft.serialization"),
    // logLevel in (Compile, scalaxb) := Level.Debug
  )
