package utils
import org.apache.spark.sql.SparkSession
import org.apache.spark.SparkConf

import scala.io.StdIn

object SparkUtils {
  val defaultConf: SparkConf = new SparkConf()
    .setMaster("yarn-client")
    .setAppName("PlaySubService")
    .set("spark.ui.enabled", "true")

  def newSession(name: String = "PlaySession") : SparkSession = {
    SparkSession.builder().config(defaultConf).appName(name).getOrCreate()
  }

  def testRunRepl() : Unit = {
    val test = newSession("ReplTest").sparkContext.parallelize(1l to 1000000000000l).filter(x => x % 2 != 0)
    println(s"There are $test even numbers")
    StdIn.readLine("[press any key to kill the web ui]")
  }
}
