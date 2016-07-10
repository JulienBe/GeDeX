package creature

import brols.Creator

import scala.util.Random

/**
  * Created by julein on 09/07/16.
  */
case class CreatureGenome(val bodies: List[(BodyGenome, ShapeGenome)], val joints: List[JointGenome])

object CreatureGenome {
  val jointRatio = 2f

  def createGenome(minBodies: Int, maxBodies: Int) = {
    val nbBodies = Random.nextInt(maxBodies - minBodies) + 1
    val bodiesGenome = List.tabulate(nbBodies)(i =>
      new Tuple2[BodyGenome, ShapeGenome](BodyGenome.create(), ShapeGenome.create())
    )
    val nbJoint = Creator.valueInBounds(nbBodies - 1, nbBodies * (nbBodies - 1))
    val jointGenome = List.tabulate(nbJoint.toInt)(i =>
      JointGenome.createJoint(bodiesGenome)
    )
    new CreatureGenome(bodiesGenome, jointGenome)
  }
}