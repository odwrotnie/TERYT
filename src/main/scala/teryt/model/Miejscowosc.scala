package teryt.model

case class Miejscowosc(name: String, gmina: Gmina)
  extends Location {

  override def ident: Option[String] = None

  override def toString = "%s" format name
}
