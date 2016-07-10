package world

import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.physics.box2d.World
import creature.{Creature, CreatureGenome}
import main.GameState

/**
  * Created by julien on 25/06/16.
  */
object GameWorld {

  val tilesNumber = 100
  val width = 160
  val height = 100
  val box2Dworld = new World(new Vector2(0f, -9.89f), true)
  var creatures: List[Creature] = List.empty

  def createInitialPopulation(max: Int) = {
    creatures = List.tabulate(max)( i =>
      new Creature(CreatureGenome.createGenome(1, 6)).live(box2Dworld)
    )
  }
  def createWorld() = {
    val list = List.tabulate(tilesNumber)(i => new Tuple2[Int, Tile](i, Tile.getTile(i, 1, box2Dworld)))
    GameState.setTiles(list)
  }
  def getMaxRight() = creatures.maxBy(_.rightCenter().x).rightCenter()
}