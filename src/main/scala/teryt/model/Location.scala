package teryt.model

abstract class Location {

  def name: String

  def ident: Option[String]

  var parent: Option[Location] = None

  var children = scala.collection.mutable.Set[Location]()
}
