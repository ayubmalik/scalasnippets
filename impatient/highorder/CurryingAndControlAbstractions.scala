package impatient.highorder

object Currying extends App {

  println("def mul(x: Int, y: Int) = x * y")
  println("def mul(x: Int)(y: Int) =  x * y")
  println("are equivalent\n")
  def mul(x: Int, y: Int) = x * y
  def multiplyBy(x: Int)(y: Int) =  x * y
  
  val x3 = multiplyBy(3)_
  val x5 = multiplyBy(5)_
  
  println(x3(3))
  println(x5(3))
  
  println("\n--- Control abstractions")
  def runInThread1(block: () => Unit) {
    new Thread {
      override def run() { block(); println(this.getState) }
    }.start()
  }
  
  runInThread1 { () => println("hi") }
  
   def runInThread2(block:  => Unit) {
    new Thread {
      override def run() { block ; println(this.getState) }
    }.start()
  }
   
  runInThread2{  println("hi2"); Thread.sleep(500) }
  println("--- this is call by name")
   
}