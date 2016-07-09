package world

import com.badlogic.gdx.physics.box2d.BodyDef.BodyType
import com.badlogic.gdx.physics.box2d.{BodyDef, PolygonShape, World}

/**
  * Created by julein on 09/07/16.
  */
object PhysicWizard {

  def createBodyDef(x: Float, y: Float, linearDamping: Float, angularDamping: Float, bodyType: BodyType) = {
    val bodyDef = new BodyDef
    bodyDef.`type` = bodyType
    bodyDef.angularDamping = angularDamping
    bodyDef.linearDamping = linearDamping
    bodyDef.position.set(x, y)
    bodyDef
  }

  def createBox(bodyDef: BodyDef, width: Float, height: Float, world: World) = {
    val body = world.createBody(bodyDef)
    val shape = new PolygonShape()
    shape.setAsBox(width / 2, height / 2)
    body.createFixture(shape, 0)
    shape.dispose()
    body
  }

  def setBodyDefPos(x: Float, y: Float, width: Float, height: Float, bodyDef: BodyDef) = bodyDef.position.set(x + width / 2, y + height / 2)

}
