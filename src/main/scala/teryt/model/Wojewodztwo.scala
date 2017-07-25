package teryt.model

case class Wojewodztwo(id: Int, name: String)
  extends Location {

  override def ident: Option[String] = Some(id.toString)

  override def toString = "Województwo %s" format name
}
