package teryt.model

case class Powiat(id: Int, name: String, wojewodztwo: Wojewodztwo)
  extends Location {

  override def toString = "Powiat %s" format name
}
