package creature

import com.badlogic.gdx.physics.box2d.joints.RevoluteJointDef
import com.badlogic.gdx.physics.box2d.{Body, World}

import scala.util.Random

/**
  * Created by julein on 10/07/16.
  */
case class JointGenome(bodiesIndexes: (Int, Int), speed: Float, torque: Float, length: Float) {
  def createJoint(bodies: List[Body], world: World) = {
    val bodyA = bodies(bodiesIndexes._1)
    val bodyB = bodies(bodiesIndexes._2)
    val jointDef = new RevoluteJointDef
    jointDef.enableMotor = true
    jointDef.motorSpeed = speed
    jointDef.maxMotorTorque = torque
    jointDef.initialize(bodyA, bodyB, bodyA.getWorldCenter)
    val joint = world.createJoint(jointDef)
  }
}

object JointGenome {
  /**
    * TODO : joint with center only for the moment
    */
  def createJoint(bodies: List[(BodyGenome, ShapeGenome)]) = {
    val index1 = Random.nextInt(bodies.length)
    val index2 = (index1 + 1) % bodies.length
    val damping = Random.nextFloat() * 5
    val freq = Random.nextFloat() * 5
    val length = Random.nextFloat() * 10
    new JointGenome(
      (index1, index2),
      damping,
      freq,
      length
    )
  }
}
