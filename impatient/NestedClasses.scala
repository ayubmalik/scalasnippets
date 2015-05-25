
package impatient

import scala.collection.mutable.ArrayBuffer

object NestedClasses extends App {

  // not a static class
  class Network {
    
    class Member(val name: String) {
      val contacts = new ArrayBuffer[Member]
      override def toString = "Member: " + name
    }
    
    private val members = new ArrayBuffer[Member]
    
    def join(name: String) = {
      val m = new Member(name)
      members += m
      m
    }
    
    def memberNames: String = members.map { m => m.name }.mkString(",")
  }

  val chatter = new Network
  val f = chatter.join("fred")
  val w = chatter.join("wilma")
  f.contacts += w
  println(chatter.memberNames)
  
  val fubu = new Network
  val b = fubu.join("barney")
  val c = fubu.join("charlie")
  b.contacts += c
  println(fubu.memberNames)
  //b.contacts += f // NOT allowed as Member is an *instance* class Network :O
  

  
}