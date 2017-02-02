package teryt

import teryt.Teryt.teritories
import teryt.helpers.Helpers
import teryt.model._

import scala.xml.XML

trait TeritorySupport {
  this: Helpers =>

  def tercFilename: String

  val tercXML = XML.loadFile(tercFilename)
  val teritoriesXML = tercXML \\ "teryt" \\ "catalog" \\ "row"
  val teritories = teritoriesXML map { row =>
    val woj = safeToInt(row \\ "_" filter attributeValueEquals("WOJ") text)
    val pow = safeToInt(row \\ "_" filter attributeValueEquals("POW") text)
    val gmi = safeToInt(row \\ "_" filter attributeValueEquals("GMI") text)
    val rodz = safeToInt(row \\ "_" filter attributeValueEquals("RODZ") text)
    val nazwa = (row \\ "_" filter attributeValueEquals("NAZWA") text)
    val nazdod = (row \\ "_" filter attributeValueEquals("NAZDOD") text)
    val t = Teritory(woj, pow, gmi, rodz, nazwa, nazdod)
    println(t)
    t
  }

  val polska = Country("Polska")

  lazy val wojewodztwa = teritories.filter(t => t.pow == 0 && t.gmi == 0).map { t =>
    val wojewodztwo = Wojewodztwo(t.woj, t.nazwa)
    wojewodztwo.parent = Some(polska)
    polska.children += wojewodztwo
    wojewodztwo
  }
}
