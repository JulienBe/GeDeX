package main

import akka.actor.{ActorRef, ActorSystem, Props}
import com.badlogic.gdx.{Game, Screen}
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import draw.Drawer
import world.{Tile, World}
import messages.GameStarted

object Agrippa extends Game {

  val system = ActorSystem()
  val world = new World
  val gameState = new GameState(List.empty)

  override def create(): Unit = {
    world.createWorld()
    setScreen(new Drawer(new GdxProvider {}))
  }

  def setTiles(list: List[(Int, Tile)]) = {
    gameState.tiles = list
  }

}
