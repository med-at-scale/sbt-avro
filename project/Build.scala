import sbt._
import Keys._

object build extends Build {
    val sbtAvro = Project(
        id = "sbt-avro",
        base = file("."),
        settings = Defaults.defaultSettings ++ Seq[Project.Setting[_]](
            organization := "com.cavorite",
            version := "0.3.2-mas", //med at scale
            sbtPlugin := true,
            libraryDependencies ++= Seq(
                    "org.apache.avro" % "avro" % "1.7.6",
                    "org.apache.avro" % "avro-compiler" % "1.7.6"
            ),
            scalaVersion := "2.10.4",
            scalacOptions in Compile ++= Seq("-deprecation"),
            crossScalaVersions := Seq("2.10.4"),
            description := "Sbt plugin for compiling Avro sources",

            publishTo := Some(Resolver.url("sbt-plugin-releases", new URL("http://repo.scala-sbt.org/scalasbt/sbt-plugin-releases/"))(Resolver.ivyStylePatterns)),

            publishMavenStyle := false
        )
    )
}
