package draw

import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer
import world.GameWorld

/**
  * Created by julein on 05/07/16.
  */
trait GdxProvider {
  def getBox2DRendered() = new Box2DDebugRenderer()
  def getCamera() = {
    val cam = new OrthographicCamera(GameWorld.width, GameWorld.height)
    cam.position.set(cam.viewportWidth / 2f, cam.viewportHeight / 2f, 0)
    cam
  }
  def getShapeRenderer() = new ShapeRenderer()
  def getSpriteBatch() = new SpriteBatch()
}
