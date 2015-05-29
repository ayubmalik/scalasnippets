package impatient.inheritance

object Equality extends App {

  class Item(val description: String, val price: BigDecimal) {

    final override def equals(other: Any) = {
      val that = other.asInstanceOf[Item]
      if (that == null) 
        false
      else
        description == that.description && price == that.price
    }
    
    // WARNING: do not use the following. It is WRONG. The other type MUST be Any
    // to be called by scala. So always use override
    def equals(other: Item) = {
      // not called by scala for equality
    }
  }
  
  println(new Item("a", 1) == new Item("b", 1))
  println(new Item("b", 1) == new Item("b", 1))
  println(new Item("c", 1) == new Item("b", 1))
}