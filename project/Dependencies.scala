import sbt._

object Dependencies {
  lazy val raceVersion = "1.8+"

  //--- dependencies to some RACE sub-projects - http://nasarace.github.io/race/
  val raceCore = "gov.nasa.race" %% "race-core" % raceVersion
  val raceTestKit = "gov.nasa.race" %% "race-testkit" % raceVersion % Test

  //--- dependency to TensorFlow for Java - https://www.tensorflow.org/jvm/
  /** "tensorflow-core-platform" will import native libraries for all supported
   * platforms (windows-x86_64, linux-x86_64, and macosx-x86_64). This increases
   * the size of the project, significantly. For dependency exclusion look at
   * https://www.scala-sbt.org/1.x/docs/Library-Management.html */
  val tensorflow = "org.tensorflow" % "tensorflow-core-platform" % "0.3.3"
}
