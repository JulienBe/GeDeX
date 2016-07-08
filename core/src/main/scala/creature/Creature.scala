package creature

import akka.actor.Actor
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.files.FileHandle
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite
import main.GameState
import world.{GameWorld, GameWorld$, Tile}

import scala.util.Random

/**
  * Created by julein on 07/07/16.
  */
class Creature {

  var x = 0
  val sprite = {
    val sprite = new Sprite(Creature.texture)
    sprite.setBounds(10, Random.nextInt(GameWorld.height), 10, 10)
    sprite
  }

  def live() = {
    Gdx.app.postRunnable(new Runnable {
      override def run() = {
        GameState.addSprite(sprite)
      }
    })
    while(true) {
      sprite.setX(sprite.getX + 1)
      Thread sleep(10)
    }
  }

}

object Creature {
  val texture = new Texture(new FileHandle("square.png"))
}
