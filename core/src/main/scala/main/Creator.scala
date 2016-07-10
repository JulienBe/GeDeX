package main

import scala.util.Random

/**
  * Created by julein on 10/07/16.
  */
object Creator {

  def norm() = Random.nextFloat()

  def valueInBounds(min: Float, max: Float) = min + (Random.nextFloat() * (max - min))

  /**
    * >= min && < max
    */
  def testBound(min: Float, max: Float, value: Float) = value >= min && value < max

}
