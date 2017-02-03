package teryt

import com.typesafe.scalalogging.LazyLogging
import teryt.helpers.Helpers
import teryt.model._
import scala.xml._

trait TeritorySupport
  extends LazyLogging {
  this: Helpers =>

  def tercFilename: String

  val tercXML: Elem = xmlFromResources(tercFilename)
  val teritoriesXML: NodeSeq = tercXML \\ "teryt" \\ "catalog" \\ "row"
  val teritories: Seq[Teritory] = teritoriesXML map { row =>
    val woj = safeToInt(row \\ "_" filter attributeValueEquals("WOJ") text)
    val pow = safeToInt(row \\ "_" filter attributeValueEquals("POW") text)
    val gmi = safeToInt(row \\ "_" filter attributeValueEquals("GMI") text)
    val rodz = safeToInt(row \\ "_" filter attributeValueEquals("RODZ") text)
    val nazwa = row \\ "_" filter attributeValueEquals("NAZWA") text
    val nazdod = row \\ "_" filter attributeValueEquals("NAZDOD") text
    val t = Teritory(woj, pow, gmi, rodz, nazwa, nazdod)
    logger.debug(s"Teritory extracted: $t")
    t
  }
}
