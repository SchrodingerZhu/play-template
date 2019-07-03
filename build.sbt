name := """play-template"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)
val framelessVersion = "0.8.0"
resolvers += Resolver.sonatypeRepo("snapshots")

scalaVersion := "2.12.8"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "4.0.3" % Test
libraryDependencies += "com.h2database" % "h2" % "1.4.199"
resolvers ++= Seq(
  Resolver.sonatypeRepo("releases"),
  Resolver.sonatypeRepo("snapshots")
)


libraryDependencies ++= List(
  "org.typelevel" %% "cats-core" % "2.0.0-M4",
  "com.chuusai" %% "shapeless" % "2.3.3",
  "org.apache.spark" %% "spark-core" % "2.4.3",
  "org.apache.spark" %% "spark-sql" % "2.4.3",
  "org.apache.hadoop" % "hadoop-client" % "3.2.0",
  "org.typelevel" %% "cats-effect" % "1.3.1",
  "org.typelevel" %% "cats-mtl-core" % "0.4.0",
  "org.typelevel" %% "cats-tagless-macros" % "0.6",
  "org.typelevel" %% "frameless-dataset" % framelessVersion,
  "org.typelevel" %% "frameless-ml"      % framelessVersion,
  "org.typelevel" %% "frameless-cats"    % framelessVersion
)
// For Scala

scalacOptions ++= Seq(
  "-feature",
  "-deprecation",
  "-Xfatal-warnings",
  "-Ypartial-unification"
)

enablePlugins(UniversalPlugin)
enablePlugins(JavaAppPackaging)
fork := true