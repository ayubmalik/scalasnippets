package impatient.inheritance

protected class Person {
  val msg = "abc"
  def id() = "Person"
}

class Employee extends Person {
  override val msg = "def"
  override def id() = "Employee" // must use override

  def someTypeCheck(p: Person): Unit = {
    if (p.isInstanceOf[Employee]) {
      println("found emp " + p.asInstanceOf[Employee])
    } else {
      println("found person")
    }
  }
  
  def betterCheck(p: Person) = {
    p match {
      case e: Employee => e.asInstanceOf[Employee]
      case _ => p
    }
  }

}

protected class Dummy {
  def msg() = "hello"
}

private object Dummy {
  def apply() = new Dummy()
}

object Person {
  def main(args: Array[String]): Unit = {
    val p: Person = new Person
    val e: Employee = new Employee
    e.someTypeCheck(p)
    e.someTypeCheck(e)
    val d = Dummy()
    println(d.msg())
  }
}

