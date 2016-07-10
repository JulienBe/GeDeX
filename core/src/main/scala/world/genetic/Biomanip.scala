package world.genetic

import creature.Creature
import world.GameWorld

import scala.util.Random

/**
  * Created by julein on 10/07/16.
  */
object Biomanip {

  def getMostFit(creatures: List[Creature]) = GameWorld.getMaxRight()

  def determineFitness(creatures: List[Creature]) = {
    val max = getMostFit(creatures).rightCenter().x
    val mulFactor = 100f / max
    creatures.foreach(c => c.fitness = c.rightCenter().x * mulFactor)
  }

  def kill(creatures: List[Creature]): List[Creature] = {
    creatures.sortBy(_.fitness)
    creatures.filter(_.fitness > 50)
  }

  def linearElimination(f: Float) = f >= Random.nextFloat()

}
