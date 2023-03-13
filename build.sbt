enablePlugins(ScalaJSPlugin)

scalaVersion := "3.2.2"

name := "sttp-playground"
version := "0.1.0"

libraryDependencies ++= Seq(
  "com.softwaremill.sttp.client3" %%% "core" % "3.8.13",
  "com.softwaremill.sttp.client3" %%% "upickle" % "3.8.13"
)

scalaJSLinkerConfig ~= {
  _.withModuleKind(ModuleKind.ESModule)
}
