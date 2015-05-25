package impatient

object Tuples extends App {
  println((1.1, "Fred"))
  println((1.1, "Fred").getClass)
  println((1.1, "Fred", "Ed").getClass)
  val t = (1.1, "Fred", "Ed")
  println(t._1)
  println(t._2)
  println(t._3)
  
  val (first, second, third) = t
  println(first)
  val (aa, _, cc) = t
  println(aa + " " + cc)
  
  println("--- Zipping")
  val airports = List("Manchester", "Heathrow", "Barcelona")
  println(airports)
  val codes = List("MAN", "LHR", "BCN")
  println(codes)
  val pairs = airports.zip(codes)
  println(pairs.getClass.getTypeName)
  println(pairs)
  println(pairs.toMap)
}