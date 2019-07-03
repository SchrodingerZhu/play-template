package controllers

import java.io.File
import java.nio.file.{Files, Path}

import javax.inject._
import akka.stream.IOResult
import akka.stream.scaladsl._
import akka.util.ByteString
import play.api._
import play.api.data.Form
import play.api.data.Forms._
import play.api.libs.streams._
import play.api.mvc.MultipartFormData.FilePart
import play.api.mvc._
import play.core.parsers.Multipart.FileInfo

import scala.concurrent.ExecutionContext

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(cc: MessagesControllerComponents)(implicit executionContext: ExecutionContext) extends MessagesAbstractController(cc) {

  /**
   * Create an Action to render an HTML page with a welcome message.
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */

  val form = Form(
    mapping(
      "jar" -> text
    )(FormData.apply)(FormData.unapply)
  )

  def index = Action { implicit request =>
    Ok(views.html.index(form))
  }

}
