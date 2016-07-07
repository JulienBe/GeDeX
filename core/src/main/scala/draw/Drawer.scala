package draw

import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.{Gdx, Screen}
import main.{Agrippa, GdxProvider}

/**
  * Created by julein on 05/07/16.
  */
class Drawer(val gdxProvider: GdxProvider) extends Screen {

  val spriteBatch = gdxProvider.getSpriteBatch()
  val shapeRenderer = gdxProvider.getShapeRenderer()
  val camera = gdxProvider.getCamera()

  override def render(delta: Float) = {
    camera.update()
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
    spriteBatch.setProjectionMatrix(camera.combined)

    spriteBatch.begin()
//    Agrippa.gameState.tiles.foreach(_._2.draw(spriteBatch))
    Agrippa.gameState.dynamicSprites.foreach(_.draw(spriteBatch))
    spriteBatch.end()
  }

  override def resize(width: Int, height: Int) = {}
  override def hide() = {}
  override def dispose() = {}
  override def pause() = {}
  override def show() = {}
  override def resume() = {}
}
