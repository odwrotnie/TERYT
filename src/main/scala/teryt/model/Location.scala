package teryt.model

abstract class Location {
  var parent: Option[Location] = None
  var children = scala.collection.mutable.Set[Location]()
  private def printTreePrefix(prefix: String): Unit = {
    println(prefix + this)
    children.foreach(c => c.printTreePrefix(prefix + "   "))
  }
  def printTree = printTreePrefix("")
}
