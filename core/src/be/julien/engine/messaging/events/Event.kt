package be.julien.engine.messaging.events

import be.julien.engine.messaging.actors.EventSender
import be.julien.engine.messaging.actors.UndefiniedSender
import com.badlogic.gdx.utils.Pool

/**
 * Created by julein on 18/06/16.
 */
class Event: Pool.Poolable {

    var type: EventType = EventType.NONE;
    var sender: EventSender = UndefiniedSender()
    var message: Message = Message()

    override fun reset() {}

    fun type(type: EventType): Event {
        this.type = type
        return this;
    }
}

object EventPool: Pool<Event>(){
    override fun newObject(): Event {
        return Event()
    }
}