package be.julien.messaging.broker

import be.julien.messaging.actors.Listener
import be.julien.messaging.events.Event
import be.julien.messaging.events.EventType
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import org.jetbrains.spek.api.Spek

/**
 * Created by julein on 18/06/16.
 */
class ShadowBrokerTest: Spek({

    describe("the shadow broker") {
        val broker = ShadowBroker()
        val listener: Listener = mock()

        it("should register listeners") {
            assert(broker.heyListen(EventType.GAME_STARTED, listener))
            assert(broker.heyListen(EventType.GAME_STARTED, listener))
        }

        it("should forward messages to listeners") {
            val event = Event()
            event.type = EventType.GAME_STARTED
            broker.post(event)
            verify(listener, times(2)).onMessage(event)
        }
    }

})