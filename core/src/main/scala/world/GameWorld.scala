package world

import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.physics.box2d.World
import main.GameState

/**
  * Created by julien on 25/06/16.
  */
class GameWorld {

  val box2Dworld = new World(new Vector2(0f, -9.89f), true)

}

object GameWorld {
  val width = 160
  val height = 100

  def createWorld() = {
    val list = List.tabulate(10)(i => new Tuple2[Int, Tile](i, Tile.getTile(i, 1)))
    GameState.setTiles(list)
  }
}