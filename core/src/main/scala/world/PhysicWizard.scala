package world

import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType
import com.badlogic.gdx.physics.box2d._
import com.badlogic.gdx.physics.box2d.joints.RevoluteJointDef

/**
  * Created by julein on 09/07/16.
  */
object PhysicWizard {

  def createJoint(bodies: (Body, Body), jointDef: RevoluteJointDef, speed: Float, torqueToMass: Float, world: World) = {
    jointDef.enableMotor = true
    jointDef.motorSpeed = speed
    jointDef.maxMotorTorque = bodies._1.getMass * torqueToMass
    jointDef.initialize(bodies._1, bodies._2, bodies._1.getWorldCenter)
    world.createJoint(jointDef)
  }

  def createBodyDef(x: Float, y: Float, linearDamping: Float, angularDamping: Float, bodyType: BodyType) = {
    val bodyDef = new BodyDef
    bodyDef.`type` = bodyType
    bodyDef.angularDamping = angularDamping
    bodyDef.linearDamping = linearDamping
    bodyDef.position.set(x, y)
    bodyDef
  }

  def createTile(vertices: Array[Vector2], world: World, mask: Short, category: Short) = {
    val body = world.createBody(new BodyDef)
    val shape = new PolygonShape()
    shape.set(vertices)
    val fixture = body.createFixture(shape, 1)
    fixture.setFriction(.5f)
    setFilter(mask, category, fixture)
    shape.dispose()
    body
  }

  def createBox(bodyDef: BodyDef, width: Float, height: Float, world: World, mask: Short, category: Short, shapeType: Shape.Type, friction: Float) = {
    val body = world.createBody(bodyDef)
    val shape = getShape(width, height, shapeType)
    val fixture = body.createFixture(shape, 1)
//    fixture.setDensity(getMass(width, height, shapeType))
    fixture.setFriction(friction)
    fixture.setDensity(0.5f)
    fixture.setFriction(.8f)
    fixture.setRestitution(.6f)
    setFilter(mask, category, fixture)
    shape.dispose()
    body
  }

  def getMass(width: Float, height: Float, shapeType: Shape.Type) = {
    shapeType match {
      case Shape.Type.Polygon => width * height
      case Shape.Type.Circle => (width * Math.PI * Math.PI).toFloat
    }
  }

  def getShape(width: Float, height: Float, shapeType: Shape.Type): Shape = {
    shapeType match {
      case Shape.Type.Polygon =>
        val shape = new PolygonShape()
        shape.setAsBox(width / 2, height / 2)
        return shape
      case Shape.Type.Circle =>
        val shape = new CircleShape()
        shape.setRadius(width)
        return shape
    }
  }

  def setFilter(mask: Short, category: Short, fixture: Fixture): Unit = {
    val filter = new Filter
    filter.maskBits = mask
    filter.categoryBits = category
    fixture.setFilterData(filter)
  }

  def setBodyDefPos(x: Float, y: Float, width: Float, height: Float, bodyDef: BodyDef) = bodyDef.position.set(x + width / 2, y + height / 2)

}
