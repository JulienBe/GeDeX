package be.julien.game

import be.julien.engine.messaging.actors.Listener
import be.julien.engine.messaging.broker.Broker
import be.julien.engine.messaging.events.Event
import be.julien.engine.messaging.events.EventType

/**
 * Created by julein on 23/06/16.
 */
class World(broker: Broker) : Listener {
  init {
    broker.heyListen(EventType.GAME_STARTED, this)
  }

  override fun onMessage(event: Event) {
    when (event.type) {
      EventType.GAME_STARTED -> createWorld()
    }
  }

  private fun createWorld() {

  }
}