package impatient

object Maps extends App {

  val scores1 = scala.collection.mutable.Map("Alice" -> 1, "Bob" -> 2, "Charles" -> 3)
  val scores2 = Map("Alice" -> 1, "Bob" -> 2, "Charles" -> 3)
  val scores3 = Map(("Alice", 1), ("Bob", 2), ("Charles" -> 3))
  println(scores1.getClass)
  println(scores1)
  println(scores2.getClass)
  println(scores2)
  println(scores3.getClass)
  println(scores3)
  println("scores1 == scores2 ", scores1 == scores2)
  println("scores2 == scores3 ", scores2 == scores3)
  
  println(scores3.get("Bob"))
  println(scores3.getOrElse("Bob", 99))
}