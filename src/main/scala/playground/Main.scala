package playground

import sttp.client4.*
import sttp.client4.fetch.FetchBackend
import sttp.client4.upicklejson.*
import upickle.default.*

import scala.scalajs.js
import scala.scalajs.js.annotation.JSExportTopLevel

import Implicits.given

@JSExportTopLevel("openweather")
def openweather(): js.Promise[Response[String]] =
  import scala.concurrent.ExecutionContext.Implicits.global

  val backend = FetchBackend()
  val api = uri"http://api.openweathermap.org/data/2.5/weather?q=Tampere"

  backend
    .send(quickRequest.get(api))
