package impatient.highorder

object Functions extends App {

  val num = 3.14
  val fun = math.ceil _

  println(fun(num))
  println(Array(1.5, 2.6, 4.7).map(fun).mkString(","))

  println("\n--- anonymous functions")

  val triple = (x: Double) => 3 * x
  println(triple(9))

  println(Array(1.5, 2.6, 4.7).map((x: Double) => 3 * x).mkString(","))
  println(Array(1.5, 2.6, 4.7).map { (x: Double) => 3 * x }.mkString(","))

  println("\n--- Function with function parameters")

  def valueAtOneQuarter(f: (Double) => Double) = f(0.25)

  println(valueAtOneQuarter(math.ceil _))
  println(valueAtOneQuarter(math.cos _))
  println(valueAtOneQuarter(math.sqrt _))

  println("\n--- Function returning functions")
  def mulBy(factor: Double) = (x: Double) => x * factor

  val quad = mulBy(4)
  val cent = mulBy(100)

  println(quad(10))
  println(cent(10))

  println("\n--- Parameter inference ")
  println("shortcuts...")
  println("valueAtOneQuarter { (x: Double) => x + 1 }")
  println("valueAtOneQuarter { (x) => x + 1 }")
  println("valueAtOneQuarter { x => x + 1 }")
  println("valueAtOneQuarter { _ + 1 }")
  println(valueAtOneQuarter { (x: Double) => x + 1 })
  println(valueAtOneQuarter { (x) => x + 1 })
  println(valueAtOneQuarter { x => x + 1 })
  println(valueAtOneQuarter { _ + 1 })

}