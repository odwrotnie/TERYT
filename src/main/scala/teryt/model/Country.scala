package teryt.model

case class Country(name: String)
  extends Location {

  override def ident: Option[String] = None
}
