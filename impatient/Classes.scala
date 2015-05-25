
package impatient

import java.util.Date
import scala.beans.BeanProperty

object Classes extends App {

  class Counter {
    private var value = 0 // generates private value() methods

    def increment(): Unit = {
      value += 1
    }
    def current = value
  }

  val c = new Counter
  c.increment()
  println(c.current)

  class Person {
    var age = 0 // generates public age() methods
  }

  val p = new Person
  println(p.age)

  class Message { val timeStamp = new Date }

  println(new Message timeStamp)

  println("--- Object private fields")
  class Counter2 {
    private var value = 0
    private[this] var id = "x" // object-private. not even other Counter2 classes can see this.
    def increment() = value += 1
    def current = value
    def isLess(other: Counter2) = value < other.value // other.id not visible
  }

  val c2 = new Counter2
  c2.increment()
  val c3 = new Counter2
  println(c2.isLess(c3))

  println("--- JavaBean properties")
  class Person2 {
    @BeanProperty var age = 0
  }

  println(new Person2().getAge()) // JavaBean standard
  new Person2().setAge(1)

  println("--- Auxilary constructors")
  class Employee {
    private var name = ""

    def this(name: String) {
      this() // must call primary. error otherwise
      this.name = name
    }

    override def toString = "Employeee: " + name
  }

  println(new Employee)
  println(new Employee("tony"))

  println("--- Primary constructors")
  class Book(val title: String, val isbn: String) {
    println("primary constructor called")
  }

  println(new Book("dummies", "123").isbn)

  class Book2(val title: String, val isbn: String, private var price: Double)
  
  println(new Book2("dummies", "123", 1.00))
  
  class Book3(title: String) { def myTitle = title} // no public fields, but object-private
  // println(new Book3("hello").title) // error because no val/var in constructor
  println(new Book3("hello").myTitle)
  
  class Book4 private(val title: String)
  
  // println(new Book4("meh")) // error because private primary constructor :(
}