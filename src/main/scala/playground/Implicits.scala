package playground

import sttp.client4.Response

import scala.concurrent.ExecutionContext
import scala.concurrent.Future
import scala.scalajs.js

object Implicits:
  import scala.scalajs.js.JSConverters.*

  given convertFutureToJSPromise[T](using
      ExecutionContext
  ): Conversion[Future[Response[T]], js.Promise[Response[T]]] with
    override def apply(future: Future[Response[T]]): js.Promise[Response[T]] =
      future.toJSPromise
