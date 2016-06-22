package be.julien.engine.messaging.broker

import be.julien.engine.messaging.actors.Listener
import be.julien.engine.messaging.events.Event
import be.julien.engine.messaging.events.EventType

/**
 * Created by julein on 18/06/16.
 */
interface Broker {
    fun post(event: Event)
    fun heyListen(eventType: EventType, listener: Listener): Boolean
}