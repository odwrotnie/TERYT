package teryt.model

case class Gmina(id: Int, name: String, powiat: Powiat)
  extends Location {

  override def ident: Option[String] = Some(id.toString)

  override def toString = "Gmina %s" format name
}
