package impatient.collections

object CommonMethods extends App {
  val l = List(1, 32, 4, 78, 50, 77, 43, 94)

  println(l.head)
  println(l.last)
  println(l.tail)
  println(l.headOption)
  println(l.lastOption)
  println(l.length)
  println(l.isEmpty)

  println(l.map("0" + _))
  println(l)
  println(l.map(x => x.toString.reverse))
  println(l.flatMap(i => List(i + 1000)))

  println(l.sum)
  println(l.min)
  println(l.max)
  println(l.product)
  println(l)
  println(l.take(3))
  println(l.drop(3))
  println(l.takeRight(3))
  println(l.dropRight(3))
  println(l.slice(3, 5))

  println(l.count(_ > 90))
  println(l.filter { x => x < 11 })
  println(l.exists { x => x < 10 })
  println(l.exists { x => x == 3 })
  println(l)
  println(l.grouped(3).toList)
  println(l.sliding(3).toList)
  println(l.reduceLeft(_ + _))
  println(l.reduceLeft((l, r) => r))
  println(l.reduceLeft((l, r) => l + r))
  println(l.reduceRight((l, r) => l + r))
  println(l.reduceRight((l, r) => r + 1000))

  println(l.foldLeft("it's")(_ + " " + _))
  println(("bunga" /: l)(_ + "." + _)) // equivalent 

  println(l.foldRight("cowa ")(_ + "." + _))
  println((l :\ "cowa")(_ + "." + _))

  val ms = "Mississippi".foldLeft(Map[Char, Int]()) {
    (m, c) => m + ((c, m.getOrElse(c, 0) + 1))
  }
  println(ms)
  val z = 'c'
  println(z -> z)

  val m1 = List(1, 2)
  val m2 = List("Jan", "Feb")
  println(m1 zip m2)
  println(m2 zip m1)

  val d1 = List(1, 2, 3)
  val d2 = List("mon", "tue")
  println(d1 zip d2) // only two
  println(d1.zipAll(d2, 1, "n/a")) // only two
  
  println("Scalas".zipWithIndex.max)
  
  // iterators
  
  val it = "I luv scala".iterator
  while (it.hasNext) print(" " + it.next)
  
 
  for(c <- "ScalaS".iterator) print(c.toUpper)
}
