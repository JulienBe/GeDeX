package main

import com.badlogic.gdx.graphics.{OrthographicCamera}
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import world.World

/**
  * Created by julein on 05/07/16.
  */
trait GdxProvider {
  def getCamera() = new OrthographicCamera(World.width, World.height)
  def getShapeRenderer() = new ShapeRenderer()
  def getSpriteBatch() = new SpriteBatch()
}
