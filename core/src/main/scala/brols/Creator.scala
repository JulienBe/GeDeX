package brols

import scala.util.Random

/**
  * Created by julein on 10/07/16.
  */
object Creator {

  def float = Random.nextFloat
  def boolean = Random.nextBoolean
  def int(max: Int) = Random.nextInt(max)
  def valueInBounds(min: Float, max: Float) = min + (Random.nextFloat() * (max - min))
  def positiveValueInBounds(min: Float, max: Float) = {
    if (min < 0)  valueInBounds(0, max)
    else          valueInBounds(min, max)
  }
  def valueInBoundsWithCheck(min: Float, max: Float, checkMin: Float, checkMax: Float) = {
    valueInBounds(if (min < checkMin) checkMin else min, if (max > checkMax) checkMax else max)
  }

  /**
    * >= min && < max
    */
  def testBound(min: Float, max: Float, value: Float) = value >= min && value < max

  def randomIntNot(ceiling: Int, not: Int) = {
    var rep = Random.nextInt(ceiling)
    if (rep == not)
      rep = (rep + 1) % ceiling
    rep
  }

}
