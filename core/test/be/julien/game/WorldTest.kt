package be.julien.game

import be.julien.engine.messaging.broker.Broker
import be.julien.engine.messaging.events.Event
import be.julien.engine.messaging.events.EventType
import com.nhaarman.mockito_kotlin.*
import org.jetbrains.spek.api.Spek

/**
 * Created by julein on 23/06/16.
 */
class WorldTest : Spek({
  describe("The world manager") {
    it("should register to game created") {
      val broker: Broker = mock()
      val world = World(broker)
      verify(broker).heyListen(EventType.GAME_STARTED, world)
    }

    it("should create world when receives a game start message") {
      val world: World = mock()
      world.onMessage(Event().type(EventType.GAME_STARTED))
    }
  }
})