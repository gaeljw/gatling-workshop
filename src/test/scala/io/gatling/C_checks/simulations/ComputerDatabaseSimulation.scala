package io.gatling.C_checks.simulations

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef.http
import io.gatling.C_checks.scenarios.SearchAndEditScenario

class ComputerDatabaseSimulation extends Simulation {

  private val httpConf = http.baseUrl("http://computer-database.gatling.io")

  setUp(
    SearchAndEditScenario.searchAndEdit.inject(rampUsers(10) during (10 seconds))
  ).protocols(httpConf)
}
