package creature

import akka.actor.Actor
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.Sprite
import main.Agrippa
import world.Tile

/**
  * Created by julein on 07/07/16.
  */
class Creature extends Actor {

  var x = 0
  val sprite = {
    val sprite = new Sprite(Tile.tr)
    sprite.setBounds(10, 10, 10, 10)
    sprite
  }

  def live(): Unit = {
    Gdx.app.postRunnable(new Runnable {
      override def run() = {
        Agrippa.addSprite(sprite)
      }
    })
    while(true) {
      sprite.setX(sprite.getX + 1)
      Thread sleep(10)
    }
  }

  override def receive = {
    case _ => live()
  }
}
