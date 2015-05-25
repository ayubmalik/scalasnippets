package impatient

class PersonWithPackagePrivateDescription {
  val age = 12
  private[impatient] def description = "I am package private to impatient"
}


object Vis extends App {
  println(this.getClass)
  println(new PersonWithPackagePrivateDescription().description)
}
