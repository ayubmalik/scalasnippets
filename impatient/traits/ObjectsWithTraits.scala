package impatient.traits

object ObjectsWithTraits extends App {

  trait Logged {
    def log(msg: String) = () // no-op not abstract
  }

  class SavingsAccount extends Serializable with Logged {
    def withdraw(amount: Double): Unit = {
      // do some work
      log("withdraw " + amount)
    }
  }

  // no-op logger
  val s1 = new SavingsAccount
  s1.withdraw(99.00)

  trait ConsoleLogger extends Logged {
    override def log(msg: String) = println("LOG: " + msg)
  }

  // Now add trait to object!
  val s2 = new SavingsAccount with ConsoleLogger
  s2.withdraw(88.88)

}