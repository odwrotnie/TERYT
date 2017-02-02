package teryt.helpers

import scala.xml.Node

trait Helpers {

  def attributeValueEquals(value: String)(node: Node) =
    node.attributes.exists(_.value.text == value)

  def safeToInt(s: String): Int = s match {
    case "" => 0
    case s => s.toInt
  }
}
