package Actors

import Messages.{Result, Work}
import akka.actor.ActorSystem
import akka.testkit.{ImplicitSender, TestActorRef, TestKit}
import org.scalatest.{BeforeAndAfterAll, Matchers, WordSpecLike}

class WorkerTest extends TestKit(ActorSystem("PI-akka")) with ImplicitSender with WordSpecLike
  with Matchers with BeforeAndAfterAll {

  override def afterAll: Unit = {
    TestKit.shutdownActorSystem(system)
  }

  def summationTestCase(start: Int, nElem: Int, expPI: Double): Unit = {
    val workerActor = TestActorRef[Worker]
    workerActor ! Work(start, nElem)
    expectMsg(Result(expPI))
  }

  "Worker actor" must {
    "compute correctly the summation" in {
      //      import Actors.Worker
      summationTestCase(0, 1, 4)
    }
    "k=3" in {
      summationTestCase(0,3,4.0*(1.0-1.0/3.0+1.0/5.0))
    }
  }
}
