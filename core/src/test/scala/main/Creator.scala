package scala.main

import main.Creator
import org.scalatest.FlatSpec

import scala.util.Random

/**
  * Created by julein on 10/07/16.
  */
class CreatorTest extends FlatSpec {

  behavior of "Creator"

  it should "produce value between bounds" in {
    for (i <- 1 to 100) {
      val min = -100 * i * Random.nextFloat
      val max = 100 * i * Random.nextFloat
      val n = Creator.valueInBounds(min, max)
      assert(n >= min)
      assert(n < max)
    }
  }

}
