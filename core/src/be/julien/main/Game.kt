package be.julien.main

import be.julien.engine.graphics.Drawer
import be.julien.engine.messaging.broker.Broker
import be.julien.engine.messaging.broker.ShadowBroker
import be.julien.engine.messaging.events.EventPool
import be.julien.engine.messaging.events.EventType
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20

/**
 * Created by julein on 20/06/16.
 */

class Game(val provider: Provider) {

    val drawer: Drawer = provider.drawer()
    val broker: Broker = ShadowBroker

    fun create() {
        broker.post(EventPool.obtain().type(EventType.GAME_STARTED))
    }

    fun render() {
        Gdx.gl.glClearColor(1f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        drawer.begin()
        drawer.end()
    }
}