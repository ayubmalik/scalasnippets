package impatient
object Imports extends App {
  log("--- import wildcards")
  import java.sql._
  log(new Date(1L))

  log("--- import type")
  import java.awt.Color
  log(Color.BLACK)

  log("--- import type members")
  import java.awt.Color._
  log(darkGray)

  log("--- import sub packages")
  import java.nio._
  log(new file.AccessDeniedException(""))

  log("--- import selectors")
  import java.text.{ Format, DecimalFormat }
  log(new DecimalFormat())

  log("--- import renaming")
  import java.text.{ SimpleDateFormat => Sdf }
  log(new Sdf())
  
  log("--- import hiding")
  import java.util.{ HashMap => _}
  import scala.collection.mutable.HashMap
  log(new HashMap())
  
  log("--- implicit import of packages")
  log("import java.lang._")
  log("import scala._")
  log("import Predef._")
}