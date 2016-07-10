package creature

import com.badlogic.gdx.files.FileHandle
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType.DynamicBody
import com.badlogic.gdx.physics.box2d.World
import world.GameWorld

import scala.util.Random

/**
  * Created by julein on 07/07/16.
  * TODO : Test each is own world
  */
class Creature {

  var x = 20
  var y = 20

  val sprite = {
    val sprite = new Sprite(Creature.texture)
    sprite.setBounds(10, Random.nextInt(GameWorld.height), 10, 10)
    sprite
  }

  def live(creatureGenome: CreatureGenome, world: World, mask: Short) = {
    for (genome <- creatureGenome.bodies) {
      val bodyDef = genome._1.createBodyDef(x, y, DynamicBody)
      val body = genome._2.createShape(bodyDef, world, mask)
    }
  }

}

object Creature {
  val texture = new Texture(new FileHandle("square.png"))
}
