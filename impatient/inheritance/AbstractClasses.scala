package impatient.inheritance

object AbstractClasses extends App {

  abstract class Person {
    def id: Int
    val name: String
  }

  case class Student(val id: Int, val name: String) extends Person
  println(Student(1, "a"))
  println(Student(2, "b"))
  
  abstract class Employee {
    val id: Int       // no initialize, Abstract field with getter
    var dept: String  // abstract field with getter/setter
  }
  
 class Developer extends Employee {
    val id = 1
    var dept = "i"
  }
}