enablePlugins(ScalaJSPlugin)

scalaVersion := "3.2.2"

name := "sttp-playground"
version := "0.1.0"

libraryDependencies ++= Seq(
  "com.softwaremill.sttp.client4" %%% "core" % "4.0.0-M1",
  "com.softwaremill.sttp.client4" %%% "upickle" % "4.0.0-M1"
)

scalacOptions ++= Seq(
  "-encoding",
  "UTF-8",
  "-feature",
  "-deprecation",
  "-unchecked",
  "-explaintypes",
  "-Werror",
  "-language:existentials",
  "-language:higherKinds",
  "-language:implicitConversions"
)

scalaJSLinkerConfig ~= {
  _.withModuleKind(ModuleKind.ESModule)
}
