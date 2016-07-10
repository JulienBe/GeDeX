package creature

import com.badlogic.gdx.files.FileHandle
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType.DynamicBody
import com.badlogic.gdx.physics.box2d.{Body, World}
import world.{GameWorld, Tile}

import scala.util.Random

/**
  * Created by julein on 07/07/16.
  * TODO : Test each is own world
  */
class Creature(val genome: CreatureGenome) {

  var fitness = 0f
  var x = 30
  var y = 40
  var bodies: List[Body] = List.empty

  val sprite = {
    val sprite = new Sprite(Creature.texture)
    sprite.setBounds(10, Random.nextInt(GameWorld.height), 10, 10)
    sprite
  }

  def live(world: World) = {
    val bodies = List.tabulate(genome.bodies.length)( i =>
      genome.bodies(i)._2.createShape(genome.bodies(i)._1.createBodyDef(x, y, DynamicBody), world, Creature.mask, Creature.category)
    )
    this.bodies = bodies
    genome.joints.foreach(_.createJoint(bodies, world))
    this
  }

  def rightCenter() = bodies.maxBy(_.getWorldCenter.x).getWorldCenter

}

object Creature {
  val category : Short = 0x0001
  val mask: Short = Tile.category
  val texture = new Texture(new FileHandle("square.png"))
}
