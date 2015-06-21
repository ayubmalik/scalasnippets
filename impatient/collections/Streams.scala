package impatient.collections

import scala.io.Source

object Streams extends App {

  def numsFrom(n: BigInt): Stream[BigInt] = n #:: numsFrom(n + 1)
  val tenOrMore = numsFrom(100000)

  println(tenOrMore.tail)
  println(tenOrMore.tail.tail.tail)
  println(tenOrMore.take(10).force)

  val lorem = Source.fromFile("lorem.txt")
  val words = lorem.getLines
  println(words.mkString)
  // does not print second time as iterator can only visit once
  println(words.mkString)

  // using streams caches lines
  val lorem2 = Source.fromFile("lorem.txt")
  val words2 = lorem2.getLines.toStream
  println(words2)
  println(words2)
  println(words2(2))
  println(words2(3))
  println(words2.tail.tail)
  
  println("--- lazy views")
  
  val powers = (0 until 100).view.map(Math.pow(2, _))
  println(powers(1))
  println(powers.force)
}