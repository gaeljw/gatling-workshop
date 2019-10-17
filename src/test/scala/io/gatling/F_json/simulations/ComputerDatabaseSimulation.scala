package io.gatling.F_json.simulations

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef.http
import io.gatling.F_json.scenarios.JsonScenario

class ComputerDatabaseSimulation extends Simulation {

  private val httpConf = http.baseUrl("https://jsonplaceholder.typicode.com")

  setUp(
    JsonScenario.search.inject(rampUsers(5) during (10 seconds))
  ).protocols(httpConf)
}
