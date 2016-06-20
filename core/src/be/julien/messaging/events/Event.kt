package be.julien.messaging.events

import be.julien.messaging.actors.EventSender
import be.julien.messaging.actors.UndefiniedSender
import com.badlogic.gdx.utils.Pool

/**
 * Created by julein on 18/06/16.
 */
class Event: Pool.Poolable {

    var type: EventType = EventType.NONE;
    var sender: EventSender = UndefiniedSender()
    var message: Message = Message()

    override fun reset() {}
}

object EventPool: Pool<Event>(){
    override fun newObject(): Event {
        return Event()
    }
}