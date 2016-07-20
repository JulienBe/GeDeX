package creature

import brols.Creator
import com.badlogic.gdx.physics.box2d.{Body, BodyDef, Shape, World}
import world.PhysicWizard

import scala.util.Random

/**
  * Created by julein on 09/07/16.
  */
case class ShapeGenome(width: Float, height: Float, shapeType: Shape.Type) {
  def createShape(bodyDef: BodyDef, world: World, mask: Short, category: Short): Body = PhysicWizard.createBox(bodyDef, width, height, world, mask, category, shapeType)
}

object ShapeGenome {

  val sizeFactor = 10
  val mutationAmplitude = 2

  def getMutation(shapeGenome: ShapeGenome) = {
    new ShapeGenome(
      Creator.positiveValueInBounds(shapeGenome.width - mutationAmplitude, shapeGenome.width + mutationAmplitude),
      Creator.positiveValueInBounds(shapeGenome.height - mutationAmplitude, shapeGenome.height + mutationAmplitude),
      shapeGenome.shapeType
    )
  }
  def create() = new ShapeGenome(Random.nextFloat() * sizeFactor, Random.nextFloat() * sizeFactor, if (Creator.boolean) Shape.Type.Circle else Shape.Type.Polygon)
}