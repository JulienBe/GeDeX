package scala.creature

import creature.BodyGenome
import org.scalatest.FlatSpec

/**
  * Created by julein on 10/07/16.
  */
class BodyGenomeTest extends FlatSpec {

  behavior of "Body Genome"

  it should "create genome with correct values" in {
    for (i <- 0 until 100) {
      val b = BodyGenome.create()
      assert(b.angularDamping >= 0)
      assert(b.angularDamping < 1)
      assert(b.linearDamping >= 0)
      assert(b.linearDamping < 1)
      assert(b.xOffset >= -BodyGenome.offsetMul)
      assert(b.xOffset < BodyGenome.offsetMul)
    }
  }

}
