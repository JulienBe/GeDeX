package main

import akka.actor.{ActorRef, ActorSystem, Props}
import com.badlogic.gdx.Game
import world.World
import messages.GameStarted

object Agrippa extends Game {

  val system = ActorSystem()

  override def create(): Unit = {
    val world = system.actorOf(Props(new World))
    world.tell(GameStarted, ActorRef.noSender)
  }

  override def render() {}
}
