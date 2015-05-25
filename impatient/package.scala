package object impatient {
  def p(msg: String) = println(msg)
  def log(msg: String) = println(msg)
  def log(c: Any) = {
    println(c.getClass().getName)
  }
}