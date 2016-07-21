package creature

import brols.Creator
import com.badlogic.gdx.physics.box2d.{BodyDef, Shape, World}
import world.PhysicWizard
import world.genetic.Biomanip

/**
  * Created by julein on 09/07/16.
  */
case class ShapeGenome(width: Float, height: Float, friction: Float, shapeType: Shape.Type) {
  def createShape(bodyDef: BodyDef, world: World, mask: Short, category: Short) = PhysicWizard.createBox(bodyDef, width, height, world, mask, category, shapeType, friction)
}

object ShapeGenome {

  val sizeFactor = 10
  val dimensionMutator = new Mutator(1, 10, 2)
  val frictionMutator = new Mutator(.2f, .8f, .1f)

  def getMutation(genome: ShapeGenome) = new ShapeGenome(
    Biomanip.mutateFloat(genome.width, dimensionMutator),
    Biomanip.mutateFloat(genome.height, dimensionMutator),
    Biomanip.mutateFloat(genome.friction, frictionMutator),
    genome.shapeType
  )

  def create() = new ShapeGenome(
    Biomanip.createFloat(dimensionMutator),
    Biomanip.createFloat(dimensionMutator),
    Biomanip.createFloat(frictionMutator),
    if (Creator.boolean) Shape.Type.Circle else Shape.Type.Polygon
  )
}