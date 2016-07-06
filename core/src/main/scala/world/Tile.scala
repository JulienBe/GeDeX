package world

import com.badlogic.gdx.files.FileHandle
import com.badlogic.gdx.graphics.Texture

/**
  * Created by julein on 26/06/16.
  */
case class Tile(val x: Int, val y: Int)

object Tile {
  val tr = new Texture(new FileHandle("square.png"))
  val width = 10
  val height = 10
}