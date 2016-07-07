package main

import akka.actor.{ActorRef, ActorSystem, Props}
import com.badlogic.gdx.Game
import com.badlogic.gdx.graphics.g2d.Sprite
import creature.Creature
import draw.Drawer
import world.{Tile, World}

object Agrippa extends Game {

  val system = ActorSystem()
  val world = new World
  val gameState = new GameState(List.empty, List.empty)

  override def create(): Unit = {
    world.createWorld()
    setScreen(new Drawer(new GdxProvider {}))
    val creature = system.actorOf(Props[Creature])
    creature.tell("Live", ActorRef.noSender)
  }

  // Used by post runnable, they will be executed before each frame is rendered
  // **************

  def setTiles(list: List[(Int, Tile)]) = {
    gameState.tiles = list
  }

  def addSprite(sprite: Sprite): Unit = {
    gameState.dynamicSprites = gameState.dynamicSprites :+ sprite
  }

}
