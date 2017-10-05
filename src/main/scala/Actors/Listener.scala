package Actors
import Messages.PiApproximation
import akka.actor.Actor

class Listener extends Actor {
  override def receive = {
    case PiApproximation(computedPi, duration) =>
      val errorPI = Math.abs(Math.PI - computedPi)

      println("computed PI = %.15f (%d ms)".format(computedPi, duration.toMillis))
      println("PI = %.15f".format(Math.PI))
      println("Error: %e --- %3.6f%%".format(errorPI, 100.0 / Math.PI * errorPI))
      context.system.terminate()
  }
}
