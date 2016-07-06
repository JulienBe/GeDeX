package draw

import com.badlogic.gdx.Screen
import main.{Agrippa, GdxProvider}
import world.Tile

/**
  * Created by julein on 05/07/16.
  */
class Drawer(val gdxProvider: GdxProvider) extends Screen {

  val spriteBatch = gdxProvider.getSpriteBatch()
  val shapeRenderer = gdxProvider.getShapeRenderer()

  override def render(delta: Float) = {
    spriteBatch.begin()
    for (pair <- Agrippa.gameState.tiles)
      spriteBatch.draw(Tile.tr, pair._2.x, pair._2.y, Tile.width, Tile.height)
    spriteBatch.end()
  }

  override def resize(width: Int, height: Int) = {}
  override def hide() = {}
  override def dispose() = {}
  override def pause() = {}
  override def show() = {}
  override def resume() = {}
}
