package teryt.model

case class Gmina(id: Int, name: String, powiat: Powiat)
  extends Location {

  override def toString = "Gmina %s" format name
}
