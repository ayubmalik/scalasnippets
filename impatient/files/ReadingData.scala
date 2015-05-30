package impatient.files

import scala.io.StdIn

object ReadingData extends App {

  import scala.io.Source

  val source = Source.fromFile("lorem.txt", "UTF-8")

  println(s"Source: $source")
  println(source.mkString)

  println("src finished?")
  val it = source.getLines
  for (l <- it) println(l.toUpperCase)
  source.close

  println("--- process chars")
  val s2 = Source.fromFile("lorem.txt", "UTF-8")
  
  println("highlighting 's'")
  val t0 = System.currentTimeMillis
  val iter = s2.buffered
  while(iter.hasNext) {
    if (iter.head.toLower == 's') 
      print("(" + iter.next + ")")
    else
      print(iter.next())
  }
  s2.close
  println("\ntook " + (System.currentTimeMillis - t0) + "ms")
  
  println("--- reading tokens")
  val s3 = Source.fromFile("lorem.txt", "UTF-8")
  val tokens = s3.mkString.split("\\s+")
  for (t <- tokens.slice(0,10) ) println(t)
  s3.close
  
  println("--- console input")
  print("enter age: ")
  val age = StdIn.readInt()
  println("age = " + age)
}