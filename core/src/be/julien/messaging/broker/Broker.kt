package be.julien.messaging.broker

import be.julien.messaging.actors.Listener
import be.julien.messaging.events.Event
import be.julien.messaging.events.EventType

/**
 * Created by julein on 18/06/16.
 */
interface Broker {
    fun post(event: Event)
    fun heyListen(eventType: EventType, listener: Listener): Boolean
}