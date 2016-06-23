package be.julien.game

import be.julien.engine.messaging.actors.Listener
import be.julien.engine.messaging.broker.Broker
import be.julien.engine.messaging.events.EventType

/**
 * Created by julein on 23/06/16.
 */
class GameStateManipulator(broker: Broker) : Listener {
  init {
    broker.heyListen(EventType.GAME_STARTED, this)
  }
}