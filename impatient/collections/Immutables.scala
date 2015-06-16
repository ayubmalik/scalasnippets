package impatient.collections

import scala.collection.mutable.LinkedHashSet
import scala.collection.immutable.SortedSet

object Immutables extends App {

  val l = List(4, 2)
  println(9 :: l)
  println(2 :: Nil)
  println(2 :: Nil :: l)
  println(l.head)
  println(l.tail)
  println(l :: Nil :: l)

  val s = Set(1, 2, 3, 4, 5, 6)
  s.foreach { print _ } // order not preserved

  println()
  val s2 = LinkedHashSet(3, 2, 1) // order
  println(s2)
  val s3 = SortedSet(3, 2, 1) // sorted
  println(s3)

  println(s contains 7)
  println(s3 subsetOf s)
  println(s diff s3)
  println(s union s3)
  println(s intersect s3)

  val ll = List(44, 55)
  val rr = List(77, 88, 99)
  
  println(ll ++ rr)
  println(ll ++: rr)
  println(ll +: rr)
  println(ll +: rr)
  println(ll ::: rr)
}