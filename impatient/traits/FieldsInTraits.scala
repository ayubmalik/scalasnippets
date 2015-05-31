package impatient.traits

import java.time.format.DateTimeFormatter
import java.util.Date
import java.time.LocalDate
import java.time.LocalDateTime

object FieldsInTraits extends App {

  trait Logged {
    def log(msg: String) = ()
  }

  trait ShortLogger extends Logged {
    val maxLength = 15 // concrete field
    override def log(msg: String) = println(msg.substring(0, maxLength - 3) + "...")
  }

  class SavingsAccount extends ShortLogger {
    def withdraw(amount: Double): Unit = {
      log("withdrawing amount " + amount)
    }
  }

  val s1 = new SavingsAccount
  s1.withdraw(11)
  println(s1.maxLength) // has maxLength field. Not inherited is part of class

  // abstract fields example
  trait AbsShortLogger extends Logged {
    val maxLength: Int //
    override def log(msg: String) = println(msg.substring(0, maxLength - 3) + "...")
  }

  class SavingsAccount2 extends AbsShortLogger {
    val maxLength = 11
    def withdraw(amount: Double): Unit = {
      log("withdrawing amount " + amount)
    }
  }

  val s2 = new SavingsAccount2
  s2.withdraw(12)

  println("---")
  // traits with constructors. Can ONLY have noargs constructor. params no allowed
   trait Logged2 {
    println("hello from logger")
    def log(msg: String) = ()
  }
  
  trait TimestampLogger extends Logged2 {
    println("hello from ts logger")
    override def log(msg: String) = println(LocalDateTime.now() + ": " + msg)
  }

  class Person extends Logged2 {
    log("person constructed")
  }
  
  class Person2 extends Person with TimestampLogger {
    log("person2 cons")
  }

  new Person with TimestampLogger
  println("---")
  new Person2 
  
  // also see "self types" p 124
}