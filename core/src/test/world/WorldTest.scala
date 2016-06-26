package world

import akka.actor.{ActorSystem, Props}
import akka.testkit.{TestActorRef, TestKit}
import messages.{ChangeTiles, GameStarted}
import org.scalatest.FlatSpecLike

/**
  * Created by julein on 25/06/16.
  */
class WorldTest extends TestKit(ActorSystem("GameOn")) with FlatSpecLike {

  "World" should "produce a list of tiles when it receives appropriate message" in {
    val world = TestActorRef(Props(new World()))
    world.tell(GameStarted, world)
    expectMsgClass(classOf[ChangeTiles])
  }

}
