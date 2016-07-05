package draw

import com.badlogic.gdx.Screen
import main.GdxProvider

/**
  * Created by julein on 05/07/16.
  */
class Drawer(val gdxProvider: GdxProvider) extends Screen {

  val spriteBatch = gdxProvider.getSpriteBatch()
  val shapeRenderer = gdxProvider.getShapeRenderer()

  override def render(delta: Float) = {
    shapeRenderer.setAutoShapeType(true)
    shapeRenderer.begin()
    shapeRenderer.circle(1, 1, 2)
    shapeRenderer.end()
  }

  override def resize(width: Int, height: Int) = {}
  override def hide() = {}
  override def dispose() = {}
  override def pause() = {}
  override def show() = {}
  override def resume() = {}
}
