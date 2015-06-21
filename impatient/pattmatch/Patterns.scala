package impatient.pattmatch

object Patterns extends App {

  val sign = '1'
  sign match {
    case '+'            => print("add")
    case '-'            => print("minus")
    case d if d.isDigit => println("its digit: " + d)
    case _              => println("twas " + sign)
  }

  val obj: Any = BigInt("1000")
  val msg = obj match {
    case x: Int       => "int"
    case s: String    => "string"
    case m: Map[_, _] => "map"
    case _: BigInt    => "bigint"
    case _            => "other"

  }

  println("its " + msg)
  println(BigDecimal("100.000009") + 1)
}