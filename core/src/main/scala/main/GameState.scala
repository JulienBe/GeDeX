package main

import com.badlogic.gdx.graphics.g2d.Sprite
import world.Tile

/**
  * Created by julein on 05/07/16.
  */
case class GameState(var tiles: List[(Int, Tile)], var dynamicSprites: List[Sprite])
