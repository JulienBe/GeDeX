package creature

import brols.Creator
import com.badlogic.gdx.physics.box2d.joints.RevoluteJointDef
import com.badlogic.gdx.physics.box2d.{Body, World}
import world.genetic.Biomanip

import scala.util.Random

/**
  * Created by julein on 10/07/16.
  */
case class JointGenome(bodiesIndexes: (Int, Int), speed: Float, length: Float) {
  def createJoint(bodies: List[Body], world: World) = {
    val bodyA = bodies(bodiesIndexes._1)
    val bodyB = bodies(bodiesIndexes._2)
    val jointDef = new RevoluteJointDef
    jointDef.enableMotor = true
    jointDef.motorSpeed = speed
    jointDef.maxMotorTorque = bodyA.getMass * JointGenome.torqueToMass
    jointDef.initialize(bodyA, bodyB, bodyA.getWorldCenter)
    val joint = world.createJoint(jointDef)
  }
}

object JointGenome {

  val baseSpeed = 5
  val baseLength = 2
  val torqueToMass = 8

  def getMutation(joint: JointGenome): JointGenome = {
    new JointGenome(
      joint.bodiesIndexes,
      Creator.positiveValueInBounds(joint.speed - 4, joint.speed + 4),
      Biomanip.basicMutation(joint.length, true, 2)
    )
  }
  /**
    * TODO : joint with center only for the moment
    */
  def createJoint(bodies: List[(BodyGenome, ShapeGenome)]) = {
    val index1 = Random.nextInt(bodies.length)
    val index2 = Creator.randomIntNot(bodies.length, index1)
    val speed = baseSpeed + Random.nextFloat() * baseSpeed
    val length = Creator.float * baseLength
    new JointGenome(
      (index1, index2),
      speed,
      length
    )
  }

}
