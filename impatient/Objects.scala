package impatient

import java.util.function.Predicate
import javax.naming.ldap.SortControl
import scala.collection.generic.Sorted
import scala.reflect.internal.util.StringOps
import com.sun.corba.se.impl.protocol.giopmsgheaders.Message

object Objects extends App {

  println("--- Singletons")
  object Accounts {
    println("constructor")
    private var lastNumber = 0
    def uniqueNumber() = {
      lastNumber += 1
      lastNumber
    }
  }
  println(Accounts.uniqueNumber())
  println(Accounts.uniqueNumber())

  println("--- Object with extends")
  object Somefink extends StringOps

  println(Somefink.trimAllTrailingSpace(" meh "))

  println("--- Companion objects")

  class BankAccount {
    private val id = BankAccount.uniqueNumber()
    private var balance = 0.0
    def deposit(amount: Double) = {
      balance += amount
      balance
    }
  }

  object BankAccount {
    private var lastNumber = 0
    def uniqueNumber() = {
      lastNumber += 1
      lastNumber
    }
  }
  println(new BankAccount)

  println("--- Object apply method")
  class Message(msg: String)

  object Message {
    def apply(msg: String) = new Message(msg)
  }
  val m1 = Message("hello there")
  val m2 = new Message("bah")
  println(m1)
  println(m2)

  class Message2 private (msg: String)
  object Message2 {
    def apply(msg: String) = new Message(msg)
  }
  val mm1 = Message2("bah")
  //val mm2 = new Message2("humbug") // not allowed. private primary constructor

}