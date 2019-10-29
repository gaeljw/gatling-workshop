package io.gatling.B_session.simulations

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef.http
import io.gatling.B_session.scenarios.SearchScenario

class ComputerDatabaseSimulation extends Simulation {

  private val httpConf = http.baseUrl("http://computer-database.gatling.io")

  setUp(
    /*SearchScenario.search.inject(rampUsers(10) during (10 seconds)),*/
    SearchScenario.searchWithSession.inject(rampUsers(10) during (10 seconds))
  ).protocols(httpConf)
}
