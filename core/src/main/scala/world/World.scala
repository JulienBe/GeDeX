package world

import main.Agrippa

/**
  * Created by julien on 25/06/16.
  */
class World {

  def createWorld() = {
    val list = List.tabulate(10)(i => new Tuple2[Int, Tile](i, new Tile(i * Tile.width, 1)))
    Agrippa.setTiles(list)
  }

}

object World {
  val width = 160
  val height = 100
}