package world

import com.badlogic.gdx.files.FileHandle
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite

/**
  * Created by julein on 26/06/16.
  */
class Tile() extends Sprite

object Tile {
  val tr = new Texture(new FileHandle("square.png"))
  val width = 10
  val height = 10

  /**
    * Number are passed in the tile grid numerotation
    */
  def getTile(x: Int, y: Int): Tile = {
    val tile = new Tile()
    tile.setRegion(tr)
    tile.setBounds(x * width, y * height, width, height)
    tile
  }

}