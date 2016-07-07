package main

import akka.actor.{ActorRef, ActorSystem, Props}
import com.badlogic.gdx.Game
import creature.Creature
import draw.Drawer
import world.World

object Agrippa extends Game {

  val system = ActorSystem()
  val world = new World

  override def create(): Unit = {
    world.createWorld()
    setScreen(new Drawer(new GdxProvider {}))
    for (i <- 1 until 20) {
      val creature = system.actorOf(Props[Creature])
      creature.tell("Live", ActorRef.noSender)
    }
  }

}
