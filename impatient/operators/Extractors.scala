package impatient.operators

import sun.security.util.Cache.EqualByteArray

object Extractors extends App {
  class Person(val name: String) {
    override def toString() = "[Person: " + name + "]"
  }

  object Person {
    def apply(name: String) = new Person(name)
    def unapply(p: Person) = Some(p.name)
    def unapplySeq(msg: String): Option[Seq[String]] = Some(msg.split("\\s+"))
  }

  val p = Person("babsa")
  println(p)

  p match {
    case Person(name) => println("found: " + name)
    case _            => println("bugger")
  }

  println(Person.apply("aruba"))
  println(Person.unapply(new Person("malice")))

  println(Person.unapplySeq("yo mama sho is..."))
}