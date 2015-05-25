package impatient

// nested packages
package hello {
  class Employee
}

package world {
  class Employee
}

package outer {
  object Msg {
    def print() = println("hello")
  }
  
  package inner {
    object Print {
      def print() = Msg.print()
    }
  }
}

object PackagesAndImports extends App {
  println("--- nested package declarations")
  println(new hello.Employee().getClass)
  println(new world.Employee().getClass)
  println("--- scoping rules")
  println(outer.Msg.getClass)
  println(outer.inner.Print.getClass)
  outer.inner.Print.print()
}