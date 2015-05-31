package impatient.traits

object Traits extends App {

  trait Logger {
    def log(msg: String) // abstract
  }

  class ConsoleLogger extends Logger {
    def log(msg: String) = println(msg)
  }
  
  new ConsoleLogger().log("hello there")
  
  // multiple traits
  
  class ConsoleLogger2 extends Logger with Cloneable with Serializable {
    def log(msg: String): Unit = {
      println("log: " + msg)
    }
  }
  
  new ConsoleLogger2().log("hello there")
}