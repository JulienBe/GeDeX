package be.julien.agrippa

import com.badlogic.gdx.backends.lwjgl._
import main.Agrippa

object Main extends App {
    val cfg = new LwjglApplicationConfiguration
    cfg.title = "Agrippa"
    cfg.height = 480
    cfg.width = 800
    cfg.forceExit = false
    new LwjglApplication(Agrippa, cfg)
}
