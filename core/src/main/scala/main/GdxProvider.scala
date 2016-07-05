package main

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.glutils.ShapeRenderer

/**
  * Created by julein on 05/07/16.
  */
trait GdxProvider {
  def getShapeRenderer() = new ShapeRenderer()
  def getSpriteBatch() = new SpriteBatch()
}
