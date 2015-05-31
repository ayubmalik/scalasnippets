package impatient.traits

import java.util.Date

object LayeredTraits extends App {

  trait Logged {
    def log(msg: String) = () // no-op
  }

  trait TimestampLogger extends Logged {
    override def log(msg: String) = super.log(new Date + ": " + msg) // super does not call actual superclass log method!
  }

  trait ShortLogger extends Logged {
    override def log(msg: String) = super.log(msg.substring(0, 15) + "...") // super does not call actual superclass log method!
  }

  trait ConsoleLogger extends Logged {
    override def log(msg: String) = println(msg)
  }

  class SavingsAccount extends Serializable with Logged {
    def withdraw(amount: Double): Unit = {
      log("withdrawing amount " + amount)
    }
  }

  val s1 = new SavingsAccount
  s1.withdraw(10)

  // still calls no-op
  val s2 = new SavingsAccount with TimestampLogger
  s2.withdraw(11)

  val s3 = new SavingsAccount with ConsoleLogger with TimestampLogger // order is important
  s3.withdraw(12)

  val s4 = new SavingsAccount with TimestampLogger with ConsoleLogger // order is important
  s4.withdraw(13)

  val s5 = new SavingsAccount with ConsoleLogger with TimestampLogger with ShortLogger // order is important
  s5.withdraw(13)
}