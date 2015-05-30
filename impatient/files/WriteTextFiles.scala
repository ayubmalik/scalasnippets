package impatient.files

import java.io.PrintWriter

object WriteTextFiles extends App {

  val out = new PrintWriter("_numbers.txt")
  out.printf("%6d", new Integer(100))
  out.println
  out.printf("%06d - %03.6f".format(1001, 2.68))
  out.println
  for (i <- 1 to 100) out.println(i)
  out.close
  
  // Serializable
  @SerialVersionUID(1L)
  class AnotherPerson extends Serializable {
    val name = "testes"
  }
  
  println(new AnotherPerson)
  println(new AnotherPerson().isInstanceOf[Serializable])
  
  val p = new AnotherPerson
  import java.io._
  
  val fout = new ObjectOutputStream(new FileOutputStream("/tmp/test.obj"))
  fout.writeObject(p)
  fout.close
  
  val fin = new ObjectInputStream(new FileInputStream("/tmp/test.obj"))
  val pin = fin.readObject().asInstanceOf[AnotherPerson]
  fin.close
  println(pin.name)
  

}