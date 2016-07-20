package world

import brols.Creator
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.physics.box2d.World
import creature.Creature
import main.GameState

/**
  * Created by julien on 25/06/16.
  */
object GameWorld {

  val tilesNumber = 300
  val width = 160
  val height = 100
  val heightVariation = .5f
  val box2Dworld = new World(new Vector2(0f, -9.89f), true)
  var creatures: List[Creature] = List.empty

  def createWorld() = {
    val list = List.tabulate(tilesNumber)(i => new Tuple2[Int, Tile](i, Tile.getTile(i, Creator.float * heightVariation, box2Dworld)))
    GameState.setTiles(list)
  }

  def removeAllBodies = creatures.foreach(c => c.bodies.foreach(b => box2Dworld.destroyBody(b)))
  def getMaxRight() = creatures.maxBy(_.rightCenter().x)
  def getMinRight() = creatures.minBy(_.rightCenter().x)

}
