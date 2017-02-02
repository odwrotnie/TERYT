package teryt.model

case class Wojewodztwo(id: Int, name: String)
  extends Location {

  override def toString = "Województwo %s" format name
}
