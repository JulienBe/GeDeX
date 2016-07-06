package world

import com.badlogic.gdx.graphics.g2d.TextureRegion

/**
  * Created by julein on 26/06/16.
  */
case class Tile(val x: Int, val y: Int)

object Tile {
  val tr = new TextureRegion()
  val width = 1
  val height = 1
}