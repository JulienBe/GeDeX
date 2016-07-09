package world

import com.badlogic.gdx.physics.box2d.{BodyDef, PolygonShape, World}

/**
  * Created by julein on 09/07/16.
  */
object PhysicWizard {

  def createBox(bodyDef: BodyDef, width: Float, height: Float, world: World) = {
    val body = world.createBody(bodyDef)
    val shape = new PolygonShape()
    shape.setAsBox(width / 2, height / 2)
    body.createFixture(shape, 0)
    shape.dispose()
  }

  def setBodyDefPos(x: Float, y: Float, width: Float, height: Float, bodyDef: BodyDef) = bodyDef.position.set(x + width / 2, y + height / 2)

}
