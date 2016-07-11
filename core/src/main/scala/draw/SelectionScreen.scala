package draw

import com.badlogic.gdx.Gdx
import main.Agrippa
import main.Agrippa._
import world.GameWorld
import world.genetic.Biomanip

/**
  * Created by julein on 10/07/16.
  */
class SelectionScreen(gdxProvider: GdxProvider) extends Screener(gdxProvider) {

  override def render(delta: Float) = {
    Gdx.app.log("Debug", "max : " + GameWorld.creatures.maxBy(_.rightCenter().x).rightCenter().x)
    GameWorld.creatures = Biomanip.kill(GameWorld.creatures)
    GameWorld.creatures = Biomanip.fillGaps(Agrippa.populationSize, GameWorld.creatures)
    Biomanip.live(GameWorld.creatures, GameWorld.box2Dworld)
    setScreen(new Drawer(this))
  }

}
