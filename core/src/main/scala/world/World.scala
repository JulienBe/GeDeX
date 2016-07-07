package world

import main.GameState

/**
  * Created by julien on 25/06/16.
  */
class World {

  def createWorld() = {
    val list = List.tabulate(10)(i => new Tuple2[Int, Tile](i, Tile.getTile(i, 1)))
    GameState.setTiles(list)
  }

}

object World {
  val width = 160
  val height = 100
}