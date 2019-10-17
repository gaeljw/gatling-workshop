package io.gatling.E_assertions.simulations

import scala.concurrent.duration._

import io.gatling.A_introduction.scenarios.SearchScenario
import io.gatling.core.Predef._
import io.gatling.http.Predef.http

class ComputerDatabaseSimulation extends Simulation {

  private val httpConf = http.baseUrl("http://computer-database.gatling.io")

  setUp(
    SearchScenario.search.inject(rampUsers(10) during (10 seconds))
  ).protocols(httpConf).assertions(
    global.responseTime.max.lt(300),
    global.failedRequests.percent.lt(1.0),
    forAll.responseTime.percentile3.lt(200),
    details("Search page").failedRequests.count.is(0)
  )
}
