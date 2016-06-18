package be.julien.messaging.events

import be.julien.messaging.actors.EventSender
import be.julien.messaging.actors.UndefiniedSender

/**
 * Created by julein on 18/06/16.
 */
class Event {
    public var type: EventType = EventType.NONE;
    public var sender: EventSender = UndefiniedSender()
    public var message: Message = Message()
}