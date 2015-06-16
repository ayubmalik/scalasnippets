package impatient.collections

import scala.collection.mutable.LinkedList

object Iterables extends App {
  val it = Iterable(2, 4, 6, "ab")
  println(it)

  val seq = Seq(22, 33, 44)
  println(seq)
  println(seq(1))

  val iseq = IndexedSeq("a", "b", "c")
  println(iseq(1))

  val set = Set("jan", "feb", "jan", "feb")
  println(set)

  val ll = LinkedList("ma", "da", "ra")
  println(ll.apply(1))

  val m = Map((1, 2), (2, 4))
  println(m)

  println(m.getClass)

  import scala.collection.mutable
  val mm = mutable.Map((3, 6), (4, 8))
  println(mm.getClass)

  def digits(n: Int): Set[Int] =
    if (n < 0) digits(-n)
    else if (n < 10) Set(n)
    else digits(n / 10) + (n % 10)
  
    println(digits(2))
    println(digits(23))
    println(digits(-234))
}