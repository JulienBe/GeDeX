package be.julien.engine.graphics

import com.badlogic.gdx.graphics.g2d.SpriteBatch

/**
 * Created by julein on 22/06/16.
 */
class Paint(size: Int) : SpriteBatch(size), Drawer {
    constructor() : this(1000)
}