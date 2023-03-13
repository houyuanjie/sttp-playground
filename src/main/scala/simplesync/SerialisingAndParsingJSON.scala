package simplesync

import sttp.client3.*
import sttp.client3.upicklejson.*
import upickle.default.*

import scala.scalajs.js.annotation.JSExportTopLevel

case class MyRequest(
    field1: String,
    field2: Int
) derives ReadWriter

case class HttpBinResponse(
    origin: String,
    headers: Map[String, String]
) derives ReadWriter

@JSExportTopLevel("serialisingAndParsingJSON", "simplesync")
def serialisingAndParsingJSON(): Unit =
  import scala.concurrent.ExecutionContext.Implicits.global

  val client = SimpleHttpClient()
  val request = basicRequest
    .post(uri"https://httpbin.org/post")
    .body(MyRequest("test", 42))
    .response(asJson[HttpBinResponse])
  val response = client.send(request)

  response
    .map {
      _.body match
        case Left(e) => println(s"Got response exception:\n$e")
        case Right(r) =>
          println(s"Origin's ip: ${r.origin}, header count: ${r.headers.size}")
    }
    .onComplete(_ => client.close())
