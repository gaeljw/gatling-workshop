package io.gatling.C_checks.scenarios

import scala.concurrent.duration._

import io.gatling.C_checks.processes.{Edit, Search}
import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder

object SearchAndEditScenario {

  private val computersFileName = "computers.csv"

  /**
    * Search and edit a computer
    */
   val searchAndEdit: ScenarioBuilder =
    scenario("Search and edit")
      .feed(csv(computersFileName).circular)
      .exec(Search.searchNameRequest)
      .pause(1 second)
      .exec(Search.searchComputerUrl)
      .pause(3 seconds)
      .exec(Edit.editRequest)
}

