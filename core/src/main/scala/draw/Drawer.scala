package draw

import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.{Gdx, Screen}
import main.GdxProvider
import world.GameWorld

/**
  * Created by julein on 05/07/16.
  */
class Drawer(val gdxProvider: GdxProvider) extends Screen {

  val box2DDebugRenderer = gdxProvider.getBox2DRendered()
  val shapeRenderer = gdxProvider.getShapeRenderer()
  val spriteBatch = gdxProvider.getSpriteBatch()
  val camera = gdxProvider.getCamera()

  override def render(delta: Float) = {
    camera.position.set(GameWorld.getMaxRight().x, camera.position.y, camera.position.y)
    camera.update()
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
    spriteBatch.setProjectionMatrix(camera.combined)

    box2DDebugRenderer.render(GameWorld.box2Dworld, camera.combined)
    GameWorld.box2Dworld.step(1/45f, 6, 2)

    spriteBatch.begin()
//    GameState.inst.tiles.foreach(_._2.draw(spriteBatch))
//    GameState.gameState.dynamicSprites.foreach(_.draw(spriteBatch))
    spriteBatch.end()
  }

  override def resize(width: Int, height: Int) = {}
  override def hide() = {}
  override def dispose() = {}
  override def pause() = {}
  override def show() = {}
  override def resume() = {}
}
