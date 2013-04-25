import sbt._
import Keys._

object BuildSettings {
  val buildSettings = Defaults.defaultSettings ++ Seq(
    scalaVersion := "2.10.1"
  )
}

object MyBuild extends Build {
  import BuildSettings._

  lazy val macros: Project = Project(
    "macros",
    file("macros"),
    settings = buildSettings ++ Seq(
      libraryDependencies <+= (scalaVersion)("org.scala-lang" % "scala-reflect" % _)
    ) 
  )
  
  lazy val test: Project = Project(
    "test",
    file("test"),
    settings = buildSettings
  ) dependsOn(macros)
}