package impatient.collections

import scala.collection.mutable.Stack
import scala.collection.mutable.Queue

object Mutables extends App {
  val s = Stack(0, 2)
  println(s)
  s.pop
  s.pop
  println(s)

  val q = Queue("a", "b", "d")
  println(q)
  val qq = q ++ Queue("z")
  println(qq)
  q.enqueue("f")
  println(q ++ ("s"))
  println(q += "r")
  println(q)
}