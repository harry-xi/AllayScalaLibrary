val scala3Version = "3.5.0"

val Compilonly = config("Compilonly") hide

lazy val root = project
  .in(file("."))
  .settings(
    name := "Scala-Plugin-For-Allay",
    version := "0.1.0-SNAPSHOT",
    scalaVersion := scala3Version,

    resolvers ++= Seq(
      "opencollab-repository-maven-snapshots"
        at "https://repo.opencollab.dev/maven-snapshots",
      "opencollab-repository-maven-releases"
        at "https://repo.opencollab.dev/maven-releases",
      "storehouse" at "https://storehouse.okaeri.eu/repository/maven-public/",
      "jitpack" at "https://www.jitpack.io/",
    ),

    ivyConfigurations += Compilonly,

    libraryDependencies ++= Seq(
      "org.allaymc.allay" % "api" % "master-SNAPSHOT" % Compilonly,
    ),

    Compile / unmanagedClasspath ++=
      update.value.select(configurationFilter("Compilonly"))
  )
