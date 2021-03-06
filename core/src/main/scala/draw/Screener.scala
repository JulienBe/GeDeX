package draw

import com.badlogic.gdx.Screen

/**
  * Created by julein on 10/07/16.
  */
abstract class Screener(gdxProvider: GdxProvider) extends Screen with GdxProvider {

  val shapeRenderer = gdxProvider.getShapeRenderer()
  val spriteBatch = gdxProvider.getSpriteBatch()
  val camera = gdxProvider.getCamera()

  override def getCamera() = camera
  override def getShapeRenderer() = shapeRenderer
  override def getSpriteBatch() = spriteBatch

  override def pause() = {}
  override def dispose() = {}
  override def resize(width: Int, height: Int) = {}
  override def hide() = {}
  override def show() = {}
  override def resume() = {}
}
