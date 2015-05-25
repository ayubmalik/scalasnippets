package impatient

object ForLoops {

  def main(args: Array[String]): Unit = {

    val start = System.currentTimeMillis()

    val numbers = List(1, 3, 7, 11, 13, 17, 19, 23)
    var i = 0
    while (i < 1000000) {
      for (n <- numbers) {
        n * n * n
      }
      i = i + 1
    }

    val end = System.currentTimeMillis() - start
    println("Done in " + end + "ms")

    val breeds = List("Doberman", "Yorkshire Terrier", "Dachshund", "Scottish Terrier", "Great Dane", "Portuguese Water Dog")
    for (breed <- breeds)
      println(breed)

    println("-----")

    val filtered = for {
      breed <- breeds
      if breed.startsWith("D")
    } yield breed

    println("-----")
    println(filtered)
  }
}

