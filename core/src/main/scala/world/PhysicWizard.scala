package world

import com.badlogic.gdx.physics.box2d.BodyDef.BodyType
import com.badlogic.gdx.physics.box2d._

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

  def createBox(bodyDef: BodyDef, width: Float, height: Float, world: World, mask: Short, category: Short) = {
    val body = world.createBody(bodyDef)
    val shape = new PolygonShape()
    shape.setAsBox(width / 2, height / 2)
    val fixture = body.createFixture(shape, 1)
    setFilter(mask, category, fixture)
    shape.dispose()
    body
  }

  def setFilter(mask: Short, category: Short, fixture: Fixture): Unit = {
    val filter = new Filter
    filter.maskBits = mask
    filter.categoryBits = category
    fixture.setFilterData(filter)
  }

  def setBodyDefPos(x: Float, y: Float, width: Float, height: Float, bodyDef: BodyDef) = bodyDef.position.set(x + width / 2, y + height / 2)

}
