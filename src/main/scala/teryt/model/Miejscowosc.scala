package teryt.model

case class Miejscowosc(name: String, gmina: Gmina)
  extends Location {

  override def toString = "%s" format name
}
