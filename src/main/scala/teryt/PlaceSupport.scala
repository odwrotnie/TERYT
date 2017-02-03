package teryt

import com.typesafe.scalalogging.LazyLogging
import teryt.helpers.Helpers
import teryt.model.Place
import scala.xml._

trait PlaceSupport
  extends LazyLogging {
  this: Helpers =>

  def simcFilename: String

  val simcXML: Elem = XML.loadFile(simcFilename)
  val placesXML: NodeSeq = simcXML \\ "teryt" \\ "catalog" \\ "row"
  val places: Seq[Place] = placesXML map { row =>
    val woj = safeToInt(row \\ "_" filter attributeValueEquals("WOJ") text)
    val pow = safeToInt(row \\ "_" filter attributeValueEquals("POW") text)
    val gmi = safeToInt(row \\ "_" filter attributeValueEquals("GMI") text)
    val rodz = safeToInt(row \\ "_" filter attributeValueEquals("RODZ") text)
    val nazwa = row \\ "_" filter attributeValueEquals("NAZWA") text
    val p = Place(woj, pow, gmi, rodz, nazwa)
    logger.debug(s"Place extracted: $p")
    p
  }
}
