package creature

import scala.util.Random

/**
  * Created by julein on 09/07/16.
  */
case class CreatureGenome(val bodies: List[(BodyGenome, ShapeGenome)])

object CreatureGenome {
  def createGenome(minBodies: Int, maxBodies: Int) = {
    val nbBodies = Random.nextInt(maxBodies - minBodies) + 1
    val genome = new CreatureGenome(List.tabulate(nbBodies)(i =>
      new Tuple2[BodyGenome, ShapeGenome](BodyGenome.create(), ShapeGenome.create())
    ))
    genome
  }
}
