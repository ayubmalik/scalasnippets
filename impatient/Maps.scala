package impatient

import scala.collection.SortedMap

object Maps extends App {

  val scores1 = scala.collection.mutable.Map("Alice" -> 1, "Bob" -> 2, "Charles" -> 3)
  val scores2 = Map("Alice" -> 1, "Bob" -> 2, "Charles" -> 3)
  val scores3 = Map(("Alice", 1), ("Bob", 2), ("Charles" -> 3)) // note diff styles 
  println(scores1.getClass)
  println(scores1)
  println(scores2.getClass)
  println(scores2)
  println(scores3.getClass)
  println(scores3)
  println("scores1 == scores2 ", scores1 == scores2)
  println("scores2 == scores3 ", scores2 == scores3)

  // note different type between scores.get("Bob") and scores("Bob")
  println(scores3("Bob"))
  println(scores3.get("Bob"))
  println(scores3.getOrElse("Bob", 99))
  println("--- no Dave")
  try {
    println(scores3("Dave")) // exception.
  } catch {
    case e: Throwable => println(e.getMessage)
  }
  println(scores3.getOrElse("Dave", 99))
  println(scores3.get("Dave"))
  
  println("--- Updating maps")
  scores1("Bob") = 20
  scores1("Dave") = 30
  println(scores1)
  //scores2("Bob") = 20
  val scores = scores3 + ("Ed" -> 2, "Dave" -> 5)
  println(scores) // notice no ordering implied
  println(scores - ("Alice"))
  
  println("--- Iterating maps")
  for((k,v) <- scores) println(s"$k = $v")
  for(e <- scores) println(e)
  
  println(scores.keySet)
  println(scores.values)
  
  println("--- Sorting and insert order")
  println(Map("a" -> 1, "b" ->2, "c" -> 3) + ("e" -> 5) + ("f" -> 6))
  println(SortedMap("a" -> 1, "b" ->2, "c" -> 3) + ("e" -> 5) + ("f" -> 6))
  
}