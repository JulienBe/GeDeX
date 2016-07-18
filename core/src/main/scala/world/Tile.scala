package world

import com.badlogic.gdx.files.FileHandle
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.physics.box2d.{BodyDef, Shape, World}

/**
  * Created by julein on 26/06/16.
  */
class Tile() extends Sprite {
  val bodyDef = new BodyDef()
}

object Tile {
  val tr = new Texture(new FileHandle("square.png"))
  val category: Short = 0x0002
  val mask: Short = -1
  val width = 10
  val height = 10

  /**
    * Number are passed in the tile grid coordinates
    */
  def getTile(x: Int, y: Float, world: World): Tile = {
    val tile = new Tile()
    tile.setRegion(tr)
    tile.setBounds(x * width, y * height, width, height)
    PhysicWizard.setBodyDefPos(x * width, y * height, width, height, tile.bodyDef)
    PhysicWizard.createBox(tile.bodyDef, width, height, world, mask, category, Shape.Type.Polygon)
    tile
  }

}