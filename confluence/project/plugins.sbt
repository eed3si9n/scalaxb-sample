resolvers ++= Seq(
  "sonatype-public" at "https://oss.sonatype.org/content/groups/public",
  "repo.codahale.com" at "http://repo.codahale.com")

addSbtPlugin("org.scalaxb" % "sbt-scalaxb" % "0.7.1")
