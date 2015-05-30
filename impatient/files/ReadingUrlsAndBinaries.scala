package impatient.files

import scala.io.Source
import java.io.FileInputStream
import java.io.File

object ReadingUrlsAndBinaries extends App {

  val s1 = Source.fromURL("http://api.preloved.co.uk/v1/preloved/adverts/search?limit=10&q=korg+synthesizer", "UTF-8")
  val s2 = Source.fromString("mama mia")
  
  println(s1.mkString)
  println("enter some text. ctrl-z to finish")
  val s3 = Source.stdin
  println(s3.mkString)

  println("--- binarie files. use Java libs")
  val in = new FileInputStream(new File("frank_small.jpg"))
  val bytes = new Array[Byte](8000)
  in.read(bytes)
  in.close()
  
}