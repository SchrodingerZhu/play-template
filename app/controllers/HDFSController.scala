package controllers

import java.nio.file.{Path, Paths}

import utils.HadoopUtils
import javax.inject.{Inject, Singleton}
import org.apache.jute.compiler.JFile
import play.api.libs.Files
import play.api.mvc.{AbstractController, Action, ControllerComponents, MultipartFormData}
case class FormData(name: String)
@Singleton
class HDFSController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {
  def recieve: Action[MultipartFormData[Files.TemporaryFile]] = {
    Action(parse.multipartFormData) { request =>
      request
        .body
        .file("jar")
        .map { file =>
          val filename = Paths.get(file.filename).getFileName
          println(file.ref.toAbsolutePath.toString)
          HadoopUtils.copyFile(file.ref.toAbsolutePath.toString, s"/tmp/jars/$filename")
          Ok("File uploaded")
        }
        .getOrElse {
          Redirect(routes.HomeController.index()).flashing("error" -> "Missing file")
        }
    }
  }
}
