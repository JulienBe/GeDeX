package world

import akka.actor.{Actor, Props}
import main.Hub
import messages.{ChangeTiles, GameStarted}

/**
  * Created by julien on 25/06/16.
  */
class World extends Actor {

  def createWorld() = {
    val list = List.tabulate(10)(i => new Tuple2[Int, Tile](i, new Tile))
    val msg = new ChangeTiles(list)
    context.actorOf(Props[Hub]).tell(msg, self)
  }

  override def receive = {
    case GameStarted => createWorld()
    case _ => println("received something in World")
  }

}
