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
  val timer = new Timer(30)
  var finished = false

  override def render(delta: Float) = {
    camera.position.set(Biomanip.getMostFit(GameWorld.creatures).rightCenter().x, camera.position.y, camera.position.y)
    camera.update()
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

    box2DDebugRenderer.render(GameWorld.box2Dworld, camera.combined)

    GameWorld.box2Dworld.step(1/45f, 6, 2)

    if (timer.step(delta)) {
      setScreen(new SelectionScreen(this))
    }
  }

}
