package be.julien.main

import be.julien.engine.graphics.Drawer
import be.julien.engine.graphics.Paint

/**
 * Created by julein on 21/06/16.
 */
interface Provider {

    fun drawer(): Drawer {
        return Paint()
    }

}