package Actors

import Messages.{Calculate, PiApproximation, Result, Work}
import akka.actor.{Actor, ActorRef, Props}
import akka.routing.FromConfig

import scala.concurrent.duration._

class Master(nWorkers: Int, nMesagges: Int, nElements: Int, listener: ActorRef) extends Actor {
  var computedPi: Double = _
  var nResults: Int = _
  val startTime: Long = System.currentTimeMillis

  val workerRouter: ActorRef = context.actorOf(FromConfig.props(Props[Worker]), "PI-router")
  override def receive = {
    case Calculate => {
      for (i <- 0 until nMesagges) workerRouter ! Work(i*nElements, nElements)
    }
    case Result(value) => {
      computedPi += value
      nResults += 1
      if (nResults == nMesagges) {
        listener ! PiApproximation(computedPi, (System.currentTimeMillis - startTime).millis)
        context.stop(self)
      }
    }
  }
}