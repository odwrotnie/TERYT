package hello

import com.typesafe.scalalogging.LazyLogging
import org.scalatest.FlatSpec
import teryt.Teryt

class TerytTest
  extends FlatSpec
    with LazyLogging {

  "2 plus 2" should "equal 4" in {
    logger.info(s"Teryt: ${ Teryt.polska.printTree }")
  }
}
