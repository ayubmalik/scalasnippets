package impatient

package object inner {
  val msg = "WTF?"
  def p(s: String) = println(s)
}

package inner {
  object PackageObjects extends App {
    println(inner.msg)
    p("yo")
  }
}

object Run extends App {
  inner.PackageObjects.main(Array())
  log("hello there")
}
