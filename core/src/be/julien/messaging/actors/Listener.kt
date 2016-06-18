package be.julien.messaging.actors

import be.julien.messaging.events.Event

/**
 * Created by julein on 18/06/16.
 */
interface Listener {
    fun onMessage(event: Event){}
}