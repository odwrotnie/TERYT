package teryt

import teryt.helpers.Helpers
import teryt.model._

object Teryt
  extends Helpers
    with TeritorySupport
    with PlaceSupport {

  override def simcFilename: String = "SIMC.xml"
  override def tercFilename: String = "TERC.xml"

  val powiaty = teritories.filter(t => t.pow != 0 && t.gmi == 0).map { t =>
    val wojewodztwo = wojewodztwa.filter(w => w.id == t.woj).head
    val powiat = Powiat(t.pow, t.nazwa, wojewodztwo)
    powiat.parent = Some(wojewodztwo)
    wojewodztwo.children += powiat
    powiat
  }
  val gminy = teritories.filter(t => t.pow != 0 && t.gmi != 0).map { t =>
    val wojewodztwo = wojewodztwa.filter(w => w.id == t.woj).head
    val powiat = powiaty.filter(p => p.id == t.pow && p.wojewodztwo == wojewodztwo).head
    val gmina = Gmina(t.gmi, t.nazwa, powiat)
    gmina.parent = Some(powiat)
    powiat.children += gmina
    gmina
  }
  val miejscowosci = places.map { place =>
    val wojewodztwo = wojewodztwa.filter(w => w.id == place.woj).head
    val powiat = powiaty.filter(powiat => powiat.id == place.pow && powiat.wojewodztwo == wojewodztwo).head
    val gmina = gminy.filter(gmina => gmina.id == place.gmi && gmina.powiat == powiat && gmina.powiat.wojewodztwo == wojewodztwo).head
    val miejscowosc = Miejscowosc(place.nazwa, gmina)
    miejscowosc.parent = Some(gmina)
    gmina.children += miejscowosc
    miejscowosc
  }
}
