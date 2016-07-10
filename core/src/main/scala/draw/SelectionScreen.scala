package draw

import com.badlogic.gdx.Gdx
import world.GameWorld
import world.genetic.Biomanip

/**
  * Created by julein on 10/07/16.
  */
class SelectionScreen(gdxProvider: GdxProvider) extends Screener(gdxProvider) {

  override def render(delta: Float) = {
    Biomanip.kill(GameWorld.creatures)
    Gdx.app.log("Killing", "Killing is done")
  }

}
