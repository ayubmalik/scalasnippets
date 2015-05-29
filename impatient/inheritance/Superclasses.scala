package impatient.inheritance

object Superclasses extends App {

  class Person(name: String, age: Int)

  class Student(name: String, age: Int, val yearOfStudy: Int) extends Person(name, age)

  println(new Student("ayub", 12, 1))
  println(new Student("hassan", 18, 1))
}