package be.julien.messaging.broker

import be.julien.messaging.actors.Listener
import be.julien.messaging.events.Event
import be.julien.messaging.events.EventType

/**
 * Created by julein on 18/06/16.
 */
class ShadowBroker: Broker {

    // topic, typeS ?
    private val listeners: MutableMap<EventType, MutableList<Listener>> = hashMapOf()

    override fun heyListen(eventType: EventType, listener: Listener): Boolean {
        return listeners.getOrPut(eventType) {arrayListOf()}.add(listener)
    }

    override fun post(event: Event) {
        listeners[event.type].orEmpty().forEach { it.onMessage(event) }
    }
}