package creature

import brols.Creator
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType
import world.PhysicWizard
import world.genetic.Biomanip

/**
  * Created by julein on 09/07/16.
  */
case class BodyGenome(xOffset: Float, yOFfset: Float, linearDamping: Float, angularDamping: Float) {
  def createBodyDef(x: Float, y: Float, bodyType: BodyType) = PhysicWizard.createBodyDef(x + xOffset, y + yOFfset, linearDamping, angularDamping, bodyType)
}

object BodyGenome {
  def getMutation(genome: BodyGenome) = {
    new BodyGenome(
      Biomanip.basicMutation(genome.yOFfset, false, 1),
      Biomanip.basicMutation(genome.xOffset, false, 1),
      Biomanip.basicMutation(genome.linearDamping),
      Biomanip.basicMutation(genome.angularDamping)
    )
  }

  val offsetMul = 20
  def create() = new BodyGenome(Creator.float * offsetMul, Creator.float * offsetMul, Creator.float, Creator.float)
}
