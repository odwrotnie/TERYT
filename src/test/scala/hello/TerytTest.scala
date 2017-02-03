package hello

import com.typesafe.scalalogging.LazyLogging
import org.scalatest.FlatSpec
import teryt.Teryt
import teryt.model.Location

class TerytTest
  extends FlatSpec
    with LazyLogging {

  private def logTreePrefix(location: Location, prefix: String = ""): Unit = {
    logger.info(prefix + location)
    location.children.foreach(c => logTreePrefix(c, prefix + "   "))
  }

  "2 plus 2" should "equal 4" in {
    Teryt.miejscowosci
    logTreePrefix(Teryt.polska)
  }
}
