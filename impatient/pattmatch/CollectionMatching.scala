package impatient.pattmatch

import java.util.Date

object CollectionMatching extends App {

  val array = Array(2, 4)
  array match {
    case Array(2, t)  => println("starts with 2")
    case Array(h, t)  => println(h + " : " + t)
    case Array(1, _*) => println("size > two")
    case _            => println("other")
  }

  val list = List(1, "a", 2.0, 'c')
  val result = list match {
    case 1 :: Nil      => "single 1"
    case x :: y :: Nil => "two elems only"
    case x :: y        => "multiple with tail: " + y
    case _             => "huh?"
  }

  println(result)
  // unapply / unapplySeq etc
  println("--- other extractors")

  val pattern = """(\d+) ([a-z]+)""".r
  val (number, product) = "99 bottles" match {
    case pattern(n, s) => (n, s)
    case _             => "oops!"
  }
  println("found " + number + " of " + product)

  val (x, y) = (1, 2)
  val (q, r) = BigInt(10) /% 3
  println(q, r)
  println(BigInt(10) / 3)

  println("--- patterns in expressions")
  import scala.collection.JavaConversions.propertiesAsScalaMap
  for ((k, v) <- System.getProperties.take(3)) println(k + " = " + v.toLowerCase)

  println("--- case classes have copy()")
  case class Price(price: BigDecimal, currency: String)

  val p = Price(BigDecimal("100.20"), "EUR")
  println(p.copy())
  println(p.copy(currency = "USD")) // named params can modify props

  println("--- nested matching")

  case class Item(name: String, created: Date, prices: Double*)
  val item1 = Item("orange", new Date, 1.00)
  val item2 = Item("banana", new Date, 1.50, 2.00)
  println(item1)
  println(item2)

  item2 match {
    case Item(n, c, p @ _*) => println("prices " + p)
    case _@ other           => println(other)

  }

}
