package draw

import brols.Timer
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import main.Agrippa._
import world.GameWorld
import world.genetic.Biomanip

/**
  * Created by julein on 05/07/16.
  */
class Drawer(gdxProvider: GdxProvider) extends Screener(gdxProvider) with GdxProvider {

  val box2DDebugRenderer = gdxProvider.getBox2DRendered()
  val timer = new Timer(120)
  var finished = false
  val step = 1/45f
  val nbStep = 15
  val physicTime = step * nbStep

  override def render(delta: Float) = {
    camera.position.set(Biomanip.getMostFit(GameWorld.creatures).rightCenter().x, camera.position.y, camera.position.y)
    camera.update()
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

    box2DDebugRenderer.render(GameWorld.box2Dworld, camera.combined)
    for (i <- 0 until nbStep)
      GameWorld.box2Dworld.step(step, 6, 2)
    GameWorld.creatures.foreach(c => if (c.upper.y > GameWorld.height) c.bodies.foreach(_.setActive(false)))

    if (timer.step(physicTime)) {
      setScreen(new SelectionScreen(this))
    }
  }

}