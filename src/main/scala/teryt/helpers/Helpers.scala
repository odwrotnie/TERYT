package teryt.helpers

import java.io.File

import scala.xml.{Elem, Node, XML}

trait Helpers {

  def attributeValueEquals(value: String)(node: Node) =
    node.attributes.exists(_.value.text == value)

  def safeToInt(s: String): Int = s match {
    case "" => 0
    case s => s.toInt
  }

  def xmlFromResources(path: String*): Elem = {
    val pathString = path.mkString("/", "/", "")
    val uri = getClass.getResource(pathString).toURI
    val file = new File(uri)
    XML.loadFile(file)
  }
}
