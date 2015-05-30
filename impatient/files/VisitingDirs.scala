package impatient.files

import java.io.File

object VisitingDirs extends App {

  def subdirs(dir: File): Iterator[File] = {
    val children = dir.listFiles.filter(d => d.isDirectory && !d.getName.startsWith("."))
    children.iterator ++ children.iterator.flatMap(subdirs _)
  }
  
  for (d <- subdirs(new File("."))) println(d)
}