package creature

import com.badlogic.gdx.files.FileHandle
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType.DynamicBody
import com.badlogic.gdx.physics.box2d.World
import world.{GameWorld, Tile}

import scala.util.Random

/**
  * Created by julein on 07/07/16.
  * TODO : Test each is own world
  */
class Creature {

  var x = 30
  var y = 40

  val sprite = {
    val sprite = new Sprite(Creature.texture)
    sprite.setBounds(10, Random.nextInt(GameWorld.height), 10, 10)
    sprite
  }

  def live(creatureGenome: CreatureGenome, world: World) = {
    val bodies = List.tabulate(creatureGenome.bodies.length)( i =>
      creatureGenome.bodies(i)._2.createShape(creatureGenome.bodies(i)._1.createBodyDef(x, y, DynamicBody), world, Creature.mask, Creature.category)
    )
    for (joint <- creatureGenome.joints) {
      joint.createJoint(bodies, world)
    }
  }

}

object Creature {
  val category : Short = 0x0001
  val mask: Short = Tile.category
  val texture = new Texture(new FileHandle("square.png"))
}
