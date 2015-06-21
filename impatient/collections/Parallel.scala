package impatient.collections

object Parallel extends App {

  def timed(f: () => Unit) = {
    val start = System.currentTimeMillis
    f()
    val end = System.currentTimeMillis - start
    println("took " + end + "ms")
  }

  val nums = (100000 to 2000000)
  timed(() => println("hello"))
  timed(() => nums.map { x => x * x * x * x })
  timed(() => nums.par.map { x => x * x * x * x })
  timed(() => nums.sum)
  timed(() => nums.par.sum)

  for (i <- (0 to 100)) print(i + " ")
  println()
  for (i <- (0 to 100).par) print(i + " ")
  

}