package be.julien.engine.messaging.broker

import be.julien.engine.messaging.actors.Listener
import be.julien.engine.messaging.events.Event
import be.julien.engine.messaging.events.EventType

/**
 * Created by julein on 18/06/16.
 */
object ShadowBroker: Broker {

    // topic, typeS ?
    private val listeners: MutableMap<EventType, MutableList<Listener>> = hashMapOf()

    override fun heyListen(eventType: EventType, listener: Listener): Boolean {
        return listeners.getOrPut(eventType) {arrayListOf()}.add(listener)
    }

    override fun post(event: Event) {
        listeners[event.type].orEmpty().forEach { it.onMessage(event) }
    }
}