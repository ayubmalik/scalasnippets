package impatient.traits

object TraitsForRichInterfaces extends App {

  // mix abstract and concrete
  trait Logger {
    def log(msg: String)                           // abstract
    def debug(msg: String) = log("DEBUG: " + msg)  // concrete
    def info(msg: String) = log("INFO: " + msg)    // concrete
  }
  
  trait ConsoleLogger extends Logger {
    override def log(msg: String) = println(msg)
  }
  
  class Person extends ConsoleLogger {
    log("constructing person")
  }
  
  new Person
}