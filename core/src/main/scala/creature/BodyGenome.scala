package creature

import com.badlogic.gdx.physics.box2d.BodyDef.BodyType
import main.Creator
import world.PhysicWizard

/**
  * Created by julein on 09/07/16.
  */
case class BodyGenome(xOffset: Float, yOFfset: Float, linearDamping: Float, angularDamping: Float) {
  def createBodyDef(x: Float, y: Float, bodyType: BodyType) = PhysicWizard.createBodyDef(x + xOffset, y + yOFfset, linearDamping, angularDamping, bodyType)
}

object BodyGenome {
  val offsetMul = 20
  def create() = new BodyGenome(Creator.norm * offsetMul, Creator.norm * offsetMul, Creator.norm, Creator.norm)
}
