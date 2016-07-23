package main

import akka.actor.ActorSystem
import com.badlogic.gdx.Game
import com.badlogic.gdx.physics.box2d.Box2D
import draw.{Drawer, GdxProvider}
import world.GameWorld
import world.genetic.Biomanip

object Agrippa extends Game {

  val system = ActorSystem()
  val populationSize = 70

  override def create() = {
    Box2D.init
    GameWorld.createWorld
    GameWorld.creatures = Biomanip.createInitialPopulation(populationSize, GameWorld.box2Dworld)
    setScreen(new Drawer(new GdxProvider {}))
  }

}
