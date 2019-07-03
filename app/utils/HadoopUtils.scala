package utils
import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.{FileSystem, Path}
object HadoopUtils {
  val configuration = new Configuration()
  configuration.set("fs.defaultFS", "hdfs://10.20.10.29:9000")
  val fs: FileSystem = FileSystem.get(configuration)

  def copyFile(target: String, source: String): Unit = {
      fs.copyFromLocalFile(false, true, new Path(target), new Path(source))
  }


}
