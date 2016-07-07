package main

import com.badlogic.gdx.graphics.g2d.Sprite
import world.Tile

/**
  * Created by julein on 05/07/16.
  */
case class GameState(var tiles: List[(Int, Tile)], var dynamicSprites: List[Sprite])

object GameState {
  val gameState = new GameState(List.empty, List.empty)

  def setTiles(list: List[(Int, Tile)]) = {
    gameState.tiles = list
  }

  def addSprite(sprite: Sprite): Unit = {
    gameState.dynamicSprites = gameState.dynamicSprites :+ sprite
  }

}