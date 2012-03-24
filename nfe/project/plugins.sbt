resolvers ++= Seq(
  "Sonatype Public" at "https://oss.sonatype.org/content/repositories/public/",
  "repo.codahale.com" at "http://repo.codahale.com")

addSbtPlugin("org.scalaxb" % "sbt-scalaxb" % "0.6.9-SNAPSHOT")
