import sbt.Keys._
import Dependencies._

name := "race-ml"
scalaVersion := "2.13.8"

lazy val root = (project in file(".")).
  enablePlugins(JavaAppPackaging,LauncherJarPlugin).
  settings(
    Compile / mainClass := Some("gov.nasa.race.main.ConsoleMain"),
    run / fork := true,
    run / Keys.connectInput := true,
    Test / fork := true,
    outputStrategy := Some(StdoutOutput),
    libraryDependencies ++= Seq(
      raceCore,
      raceTestKit,
      tensorflow
    )
  )