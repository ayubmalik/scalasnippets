package impatient

object Arrays extends App {

    val a = Array(2, 13, 3, 5, 7, 9, 11)
    val result = for (elem <- a if elem % 2 == 1) yield 2 * elem

    println(result.mkString(" "))

    println(a.filter(_ > 5).mkString(" "))
    println(a.filter(_ > 5).map(_ * 3).mkString(" "))
    println(a.dropRight(2).mkString(" "))
    println(a.max)
    println(a.sum)
    println(a.sorted.mkString(" "))
    println(a.sortWith(_ > _).mkString(" "))

    import scala.collection.JavaConversions._
    import scala.collection.mutable.ArrayBuffer

    val params = ArrayBuffer("ls", "-1", "/")
    println(params)
    val p = new ProcessBuilder(params).start()
    val r = scala.io.Source.fromInputStream(p.getInputStream).getLines().mkString("\n")
    println(r)
}