package impatient.collections

import scala.collection.mutable
import java.util.HashMap
import java.util.Properties

object JavaConversions extends App {
  
  import scala.collection.JavaConversions._
  import scala.collection.JavaConversions.mapAsJavaMap
  
  val sysProps: mutable.Map[String, String] = System.getProperties()
  println(sysProps)
  
  val map = Map(1 -> "Jan", 2 -> "Feb")
  val props = new Properties
  val s = Map()
  props.putAll(mapAsJavaMap(map).asInstanceOf[java.util.Map[Integer, String]])
  println(props)
 
}