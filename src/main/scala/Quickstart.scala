import sttp.client3.quick.*

import scala.scalajs.js.annotation.JSExportTopLevel

@JSExportTopLevel("quickstart", "quickstart")
def quickstart(): Unit =
  import scala.concurrent.ExecutionContext.Implicits.global

  quickRequest
    .get(uri"http://httpbin.org/ip")
    .send(backend)
    .foreach(println)
