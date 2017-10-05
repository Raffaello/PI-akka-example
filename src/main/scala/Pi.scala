import Actors.{Listener, Master}
import Messages.Calculate
import akka.actor.{ActorSystem, Props}

object Pi extends App {
  def calculate(nWorkers: Int, nElements: Int, nMessages: Int): Unit = {
    val system = ActorSystem("PI-akka")
    val listener = system.actorOf(Props[Listener], "PI-listener")
    val master = system.actorOf(Props(new Master(nWorkers, nMessages, nElements, listener)), "PI-master")

    master ! Calculate
  }

  calculate(4, 1000, 10000)
}