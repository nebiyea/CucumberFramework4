name := "selenium-scala-bdd"

version := "0.1"
scalaVersion := "2.13.12"

libraryDependencies ++= Seq(
  "org.seleniumhq.selenium" % "selenium-java" % "4.21.0",
  "io.cucumber" %% "cucumber-scala" % "8.23.0" % Test,
  "io.cucumber" % "cucumber-junit" % "7.16.1" % Test,
  "junit" % "junit" % "4.13.2" % Test
)

fork in Test := true
