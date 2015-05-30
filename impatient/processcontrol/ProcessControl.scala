import sys.process._
import scala.language.postfixOps
import java.io.File


val d:String = ("ls -l /c/tmp" !!)
println(d.toUpperCase)

val git:String = ("ls -l /" #| "grep git" !!)
println(git)

"ls -lrt / " #| "grep git" #> new File("/tmp/ls.txt") !;
"ls -lrt / " #| "grep b" #>> new File("/tmp/append.txt") !;
"ls -lrt / " #| "grep c" #>> new File("/tmp/append.txt") !;

