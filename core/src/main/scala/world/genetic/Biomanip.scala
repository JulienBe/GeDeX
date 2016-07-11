package world.genetic

import brols.Creator
import com.badlogic.gdx.physics.box2d.World
import creature._
import world.GameWorld

import scala.util.Random

/**
  * Created by julein on 10/07/16.
  */
object Biomanip {

  val mutationRate = 3
  val mutationAmplitude = 3

  def getNewMutation(genome: CreatureGenome): CreatureGenome = {
    val joints = genome.joints
    val mutatedJoint = List.tabulate(joints.length)(i =>
      new JointGenome(
        joints(i).bodiesIndexes,
        basicMutation(joints(i).speed),
        basicMutation(joints(i).torque),
        basicMutation(joints(i).length)
      )
    )
    val bodies = genome.bodies
    val mutatedBodies = List.tabulate(bodies.length)(i =>
      new Tuple2[BodyGenome, ShapeGenome](
        new BodyGenome(
          basicMutation(bodies(i)._1.yOFfset, false),
          basicMutation(bodies(i)._1.xOffset, false),
          basicMutation(bodies(i)._1.linearDamping),
          basicMutation(bodies(i)._1.angularDamping)
        ),
        new ShapeGenome(
          Creator.valueInBounds(0.1f, 10f),
          Creator.valueInBounds(0.1f, 10f)
        )
      )
    )
    new CreatureGenome(mutatedBodies, mutatedJoint)
  }

  def basicMutation(base: Float, floor: Boolean = true): Float = {
    val next = base + (Random.nextFloat() - .5f) * mutationAmplitude
    if (floor && next < 0)
      return 0
    next
  }

  def fillGaps(populationSize: Int, creatures: List[Creature]): List[Creature] = {
    val gapSize = populationSize - creatures.size
    val genomes: List[CreatureGenome] = creatures.map(_.genome)
    val newGen = List.tabulate(gapSize)(i =>
      getNewMutation(genomes(Random.nextInt(genomes.size)))
    )
    val newCreatures = newGen.map(new Creature(_))
    creatures ::: newCreatures
  }

  def createInitialPopulation(size: Int, world: World) = {
    List.tabulate(size)(i =>
      new Creature(CreatureGenome.createGenome(2, 10)).live(world)
    )
  }

  def live(creatures: List[Creature], world: World) = creatures.foreach(_.live(world))

  def getMostFit(creatures: List[Creature]) = GameWorld.getMaxRight()
  def getLessFit(creatures: List[Creature]) = GameWorld.getMinRight()

  def determineFitness(creatures: List[Creature]) = {
    val max = getMostFit(creatures).rightCenter().x
    val min = getLessFit(creatures).rightCenter().x
    val range = max - min
    creatures.foreach(c =>
      c.fitness = 100 * ((c.rightCenter().x-min) / range)
    )
  }

  def kill(creatures: List[Creature]): List[Creature] = {
    determineFitness(creatures)
    GameWorld.removeAllBodies
    val survivers = creatures.filter(_.fitness > 50)
    survivers
  }

  def linearElimination(f: Float) = f >= Random.nextFloat()

}
