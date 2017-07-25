package teryt.model

case class Powiat(id: Int, name: String, wojewodztwo: Wojewodztwo)
  extends Location {

  override def ident: Option[String] = Some(id.toString)

  override def toString = "Powiat %s" format name
}
