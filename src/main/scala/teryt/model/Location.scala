package teryt.model

abstract class Location {

  var parent: Option[Location] = None
  var children = scala.collection.mutable.Set[Location]()
}
