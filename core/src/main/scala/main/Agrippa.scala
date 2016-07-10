package main

import akka.actor.ActorSystem
import com.badlogic.gdx.Game
import com.badlogic.gdx.physics.box2d.Box2D
import draw.{Drawer, GdxProvider}
import world.GameWorld

object Agrippa extends Game {

  val system = ActorSystem()

  override def create() = {
    Box2D.init
    GameWorld.createWorld
    GameWorld.createInitialPopulation(50)
    setScreen(new Drawer(new GdxProvider {}))
  }

}
