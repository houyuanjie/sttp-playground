package simplesync

import sttp.client3.*

import scala.scalajs.js.annotation.JSExportTopLevel

@JSExportTopLevel("simpleSyncClient", "simplesync")
def simpleSyncClient(): Unit =
  import scala.concurrent.ExecutionContext.Implicits.global

  val client = SimpleHttpClient()
  client
    .send(basicRequest.get(uri"https://httpbin.org/get"))
    .map(_.body)
    .map(println)
    .onComplete(_ => client.close())
