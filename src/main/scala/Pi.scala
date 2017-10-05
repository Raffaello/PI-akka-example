import Actors.{Listener, Master}
import Messages.Calculate
import akka.actor.{ActorSystem, Props}

object Pi extends App {
  val system = ActorSystem("PI-akka")

  def calculate(nWorkers: Int, nElements: Int, nMessages: Int): Unit = {
    val listener = system.actorOf(Props[Listener], "PI-listener")
    val master = system.actorOf(Props(new Master(nWorkers, nMessages, nElements, listener)), "PI-master")

    master ! Calculate
  }

  val config = system.settings.config
  calculate(
    config.getInt("PI-akka.nr-of-workers"),
    config.getInt("PI-akka.nr-of-elements"),
    config.getInt("PI-akka.nr-of-messages")
  )
}
