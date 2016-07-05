package main

import akka.actor.Actor
import messages.ChangeTiles

/**
  * Created by julein on 26/06/16.
  */
class Hub extends Actor {

  override def receive = {
    case ChangeTiles(tiles) => println("changing tiles " + tiles)
  }

}