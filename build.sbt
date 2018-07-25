name := """scala-consul"""

version := "1.3.0"

scalaVersion := "2.11.12"

crossScalaVersions := Seq(scalaVersion.value)

scalacOptions ++= Seq(
  "-encoding", "UTF-8", "-deprecation", "-feature"
  ,"-Xfuture" //, "-Xverify", "-Xcheck-null"
  ,"-Ybackend:GenBCode"
  ,"-Ydelambdafy:method"
)

resolvers += "Bintray Typesafe Repo" at "http://dl.bintray.com/typesafe/maven-releases/"

libraryDependencies ++= Seq(
  "com.typesafe.play" %% "play-json" % "2.5.18",
  "com.typesafe.play" %% "play-ws"   % "2.5.18"
)

organization := "com.x2sy"
organizationName := "x2sy"
organizationHomepage := Some(new URL("http://x2sy.com"))

description := "Consul Scala Client"

publishMavenStyle := true

publishTo := {
  val nexus = "https://nexus.x2sy.com/repository/"
  if (isSnapshot.value)
    Some("x2sy Snapshots" at nexus + "snapshots/")
  else
    Some("x2sy Releases" at nexus + "releases/")
}

credentials += Credentials(Path.userHome / ".ivy2" / ".x2sy-credentials")
