resolvers ++= Seq(
  "sonatype-public" at "https://oss.sonatype.org/content/groups/public",
  "repo.codahale.com" at "http://repo.codahale.com")

addSbtPlugin("org.scalaxb" % "sbt-scalaxb" % "1.0.0-RC3")
