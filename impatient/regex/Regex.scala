package impatient.regex
import scala.Console.{ println => p }
object Regex extends App {

  val numPattern = "0-9".r

  p(numPattern replaceAllIn ("hello 123", ""))

  val datePatt1 = "\\d\\d/\\d\\d/\\d\\d\\d\\d".r
  p(datePatt1.findFirstIn("12/11/1972").get)

  // better?
  val datePatt2 = """\d\d/\d\d/\d\d\d\d""".r
  p(datePatt1.findFirstIn("12/11/1971").get)

  val res = datePatt1.findAllIn("12/11/1972").map { f => f.reverse }
  p(res.mkString)

  val words = """\w+""".r
  p(words.findAllIn("we, all feel the same 100").mkString("|"))
  p(words.replaceAllIn("we, all feel the same 100", "*").mkString)
  
  p("--- extraction of groups. will error if not exact num of groups")
  val dobPattern = """(\d{2})/(\d{2})/(\d{4})""".r
  val dobPattern(dd, mm, yyyy) = "12/11/1972"
  p(dd, mm, yyyy)  
}