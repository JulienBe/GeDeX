package be.julien.game

import be.julien.engine.messaging.actors.Listener
import be.julien.engine.messaging.broker.ShadowBroker
import be.julien.engine.messaging.events.EventType
import be.julien.main.Provider
import com.nhaarman.mockito_kotlin.argThat
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.jetbrains.spek.api.Spek

/**
 * Created by julein on 20/06/16.
 */
class GameTest: Spek({
    describe ("the main class") {

        it("should send create event") {
            val listener: Listener = mock()
            val provider: Provider = mock()
            ShadowBroker.heyListen(EventType.GAME_STARTED, listener)
            Game(provider).create()
            verify(listener).onMessage(argThat { type.equals(EventType.GAME_STARTED) })
        }
    }
})