package impatient.traits

object TraitsConcrete extends App {

  trait ConsoleLogger {
    def log(msg: String) = println("log: " + msg)
  }
  
  class SavingsAccount extends ConsoleLogger {
    def withdraw(amount: Double):Unit = {
      // do some work
      log("withdraw " + amount)
    }
  }
  
  new SavingsAccount().withdraw(10.0)
}