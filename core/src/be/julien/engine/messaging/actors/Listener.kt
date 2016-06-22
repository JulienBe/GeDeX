package be.julien.engine.messaging.actors

import be.julien.engine.messaging.events.Event

/**
 * Created by julein on 18/06/16.
 */
interface Listener {
    fun onMessage(event: Event){}
}