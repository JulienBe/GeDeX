package main

import com.badlogic.gdx.graphics.g2d.Sprite
import world.{GameWorld, Tile}

/**
  * Created by julein on 05/07/16.
  */
case class GameState(var tiles: List[(Int, Tile)], var dynamicSprites: List[Sprite], val gameWorld: GameWorld)

object GameState {
  val inst = new GameState(List.empty, List.empty, new GameWorld())

  def setTiles(list: List[(Int, Tile)]) = inst.tiles = list

  def addSprite(sprite: Sprite) = inst.dynamicSprites = inst.dynamicSprites :+ sprite

}