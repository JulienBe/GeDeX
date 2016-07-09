package creature

import com.badlogic.gdx.physics.box2d.BodyDef.BodyType
import world.PhysicWizard

import scala.util.Random

/**
  * Created by julein on 09/07/16.
  */
case class BodyGenome(val xOffset: Float, val yOFfset: Float, val linearDamping: Float, val angularDamping: Float) {
  def createBodyDef(x: Float, y: Float, bodyType: BodyType) = PhysicWizard.createBodyDef(x + xOffset, y + yOFfset, linearDamping, angularDamping, bodyType)
}

object BodyGenome {
  def create() = new BodyGenome(Random.nextFloat() * 10, Random.nextFloat() * 10, Random.nextFloat(), Random.nextFloat())
}
