package teryt

import teryt.helpers.Helpers
import teryt.model.Place
import scala.xml.XML

trait PlaceSupport {
  this: Helpers =>

  def simcFilename: String

  val simcXML = XML.loadFile(simcFilename)
  val placesXML = simcXML \\ "teryt" \\ "catalog" \\ "row"
  val places = placesXML map { row =>
    val woj = safeToInt(row \\ "_" filter attributeValueEquals("WOJ") text)
    val pow = safeToInt(row \\ "_" filter attributeValueEquals("POW") text)
    val gmi = safeToInt(row \\ "_" filter attributeValueEquals("GMI") text)
    val rodz = safeToInt(row \\ "_" filter attributeValueEquals("RODZ") text)
    val nazwa = (row \\ "_" filter attributeValueEquals("NAZWA") text)
    Place(woj, pow, gmi, rodz, nazwa)
  }
}
