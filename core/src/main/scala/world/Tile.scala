package world

import brols.Creator
import com.badlogic.gdx.files.FileHandle
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.physics.box2d.{BodyDef, Shape, World}

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

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
  val height = 2
  val minOffset = -3
  val maxOffset = 3
  val startHeight = 10

  /**
    * Number are passed in the tile grid coordinates
    */
  def getTile(x: Int, y: Float, world: World): Tile = {
    val tile = new Tile()
    tile.setRegion(tr)
    tile.setBounds(x * width, y * height, width, height)
    PhysicWizard.setBodyDefPos(x * width, y * height, width, height, tile.bodyDef)
    PhysicWizard.createBox(tile.bodyDef, width, height, world, mask, category, Shape.Type.Polygon, .5f)
    tile
  }

  def createFloor(nbTiles: Int, world: World) = {
    var previousRightVertices = new Tuple2[Vector2, Vector2](new Vector2(2, startHeight), new Vector2(2, startHeight - height))
    val tmpList = ListBuffer.empty

    for (i <- 0 until nbTiles) {
      val offset = Creator.valueInBounds(minOffset, maxOffset)
      val upperRight = new Vector2(previousRightVertices._1.x + width, previousRightVertices._1.y + offset)
      val downRight = new Vector2(previousRightVertices._1.x + width, previousRightVertices._2.y + offset)
      PhysicWizard.createTile(Array(
          previousRightVertices._1,
          upperRight,
          downRight,
          previousRightVertices._2),
        world,
        mask,
        category)
      previousRightVertices = new Tuple2[Vector2, Vector2](
        upperRight,
        downRight
      )
    }
  }

  def getY(previousY: Float) = {
    previousY
  }

}