name := "diybigdata-udf"

// orgnization name (e.g., the package name of the project)
organization := "net.diybigdata"

version := "1.0-SNAPSHOT"

// project description
description := "DIY Big Data Hive UDFs"

// Enables publishing to maven repo
publishMavenStyle := true

// Do not append Scala versions to the generated artifacts
crossPaths := false

// This forbids including Scala related libraries into the dependency
autoScalaLibrary := false

// Use the latest Scala version with Spark 2+
scalaVersion := "2.11.6"
scalacOptions ++= Seq("-unchecked", "-feature", "-deprecation")

// Add repositories where library dependencies can be found
resolvers += "Cloudera" at "https://repository.cloudera.com/content/repositories/releases/"
resolvers += "Central" at "http://central.maven.org/maven2/"
resolvers += "Spring Plugins" at "http://repo.spring.io/plugins-release/"

// library dependencies. (orginization name) % (project name) % (version)
libraryDependencies ++= Seq(
  "org.apache.hive" % "hive-exec" % "2.1.0" % "provided",
  "org.apache.hadoop" % "hadoop-core" % "2.6.0-mr1-cdh5.8.2",
  "com.novocode" % "junit-interface" % "0.11" % "test"
)

