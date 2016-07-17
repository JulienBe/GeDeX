package world.genetic

import com.badlogic.gdx.physics.box2d.World
import creature._
import world.GameWorld

import scala.util.Random

/**
  * Created by julein on 10/07/16.
  */
object Biomanip {

  val percentageToKeep = 0.5f
  val mutationAmplitude = 3
  var gen = 0
  val bodiesMin = 2
  val bodiesMax = 8

  def kill(creatures: List[Creature]): List[Creature] = {
    gen += 1
    determineFitness(creatures)
    GameWorld.removeAllBodies
    creatures.sortBy(_.fitness).slice((creatures.length * percentageToKeep).toInt, creatures.length)
  }
  def determineFitness(creatures: List[Creature]) = {
    val max = getMostFit(creatures).rightCenter().x
    val min = getLessFit(creatures).rightCenter().x
    val range = max - min
    creatures.foreach(c =>
      c.fitness = 100 * ((c.rightCenter().x - min) / range)
    )
  }

  def spawnNewCreatures(populationSize: Int, creatures: List[Creature]): List[Creature] = {
    val gapSize = populationSize - creatures.size
    val selectedGenomes: List[CreatureGenome] = creatures.map(_.genome)

    val newGen = List.tabulate(gapSize / 2)(i =>
      getNewMutation(selectedGenomes(Random.nextInt(selectedGenomes.size)))
    )
    val freshGen = List.tabulate(gapSize / 2)(i =>
      new Creature(CreatureGenome.createGenome(bodiesMin, bodiesMax))
    )
    val newCreatures = newGen.map(new Creature(_))
    creatures ::: newCreatures ::: freshGen
  }
  def getNewMutation(genome: CreatureGenome): CreatureGenome = {
    val mutatedJoint = List.tabulate(genome.joints.length)(i => JointGenome.getMutation(genome.joints(i)) )
    val mutatedBodies = List.tabulate(genome.bodies.length)(i =>
      new Tuple2[BodyGenome, ShapeGenome](BodyGenome.getMutation(genome.bodies(i)._1), ShapeGenome.getMutation(genome.bodies(i)._2))
    )
    new CreatureGenome(mutatedBodies, mutatedJoint)
  }
  def basicMutation(base: Float, floor: Boolean = true, factor: Float = mutationAmplitude): Float = {
    val next = base + (Random.nextFloat() - .5f) * factor
    if (floor && next < 0)
      return 0
    next
  }

  def createInitialPopulation(size: Int, world: World) = List.tabulate(size)(i => new Creature(CreatureGenome.createGenome(2, 12)).live(world))
  def live(creatures: List[Creature], world: World) = creatures.foreach(_.live(world))
  def getMostFit(creatures: List[Creature]) = GameWorld.getMaxRight()
  def getLessFit(creatures: List[Creature]) = GameWorld.getMinRight()

  def linearElimination(f: Float) = f >= Random.nextFloat()

}
