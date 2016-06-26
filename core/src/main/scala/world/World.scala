package world

import akka.actor.{Actor, Props}
import main.GameStateManipulator
import messages.{ChangeTiles, GameStarted}

/**
  * Created by julien on 25/06/16.
  */
class World extends Actor {

  def createWorld() = {
    val list = List.tabulate(10)(i => new Tuple2[Int, Tile](i, new Tile))
    val msg = new ChangeTiles(list)
    context.actorOf(Props[GameStateManipulator]).tell(msg, self)
  }

  override def receive = {
    case GameStarted => createWorld()
    case _ => println("received something in World")
  }

}
