package creature

import com.badlogic.gdx.physics.box2d.{Body, BodyDef, World}
import world.PhysicWizard

import scala.util.Random

/**
  * Created by julein on 09/07/16.
  */
case class ShapeGenome(val width: Float, val height: Float) {
  def createShape(bodyDef: BodyDef, world: World, mask: Short, category: Short): Body = PhysicWizard.createBox(bodyDef, width, height, world, mask, category)
}

object ShapeGenome {
  def create() = new ShapeGenome(Random.nextFloat() * 10, Random.nextFloat() * 10)
}