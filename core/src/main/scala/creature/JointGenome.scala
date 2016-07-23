package creature

import brols.Creator
import com.badlogic.gdx.physics.box2d.joints.RevoluteJointDef
import com.badlogic.gdx.physics.box2d.{Body, World}
import world.PhysicWizard

import scala.util.Random

/**
  * Created by julein on 10/07/16.
  */
case class JointGenome(bodiesIndexes: (Int, Int)) {
  def createJoint(bodies: List[Body], world: World) = {
    val indexA = Creator.int(bodies.length)
    val indexB = Creator.randomIntNot(bodies.length, indexA)
    PhysicWizard.createJoint((bodies(indexA), bodies(indexB)), new RevoluteJointDef, JointGenome.baseSpeed, JointGenome.torqueToMass, world)
  }
}

object JointGenome {

  val baseSpeed = 20
  val torqueToMass = 12

  def getMutation(joint: JointGenome) = new JointGenome(joint.bodiesIndexes)

  /**
    * TODO : joint with center only for the moment
    */
  def createJoint(bodies: List[(BodyGenome, ShapeGenome)]) = {
    val index1 = Random.nextInt(bodies.length)
    val index2 = Creator.randomIntNot(bodies.length, index1)
    new JointGenome((index1, index2))
  }

}
