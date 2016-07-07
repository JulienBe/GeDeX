package world

import main.Agrippa

/**
  * Created by julien on 25/06/16.
  */
class World {

  def createWorld() = {
    val list = List.tabulate(10)(i => new Tuple2[Int, Tile](i, Tile.getTile(i, 1)))
    Agrippa.setTiles(list)
  }

}

object World {
  val width = 160
  val height = 100
}