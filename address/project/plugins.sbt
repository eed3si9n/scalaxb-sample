resolvers += ("ScalaTools Nexus Snapshots" at "http://nexus.scala-tools.org/content/repositories/snapshots/")

addSbtPlugin("org.scalaxb" % "sbt-scalaxb" % "0.6.7")
// libraryDependencies <+= (sbtVersion) { sv => "org.scalaxb" %% "sbt-scalaxb" % ("sbt" + sv + "_0.6.6") }
