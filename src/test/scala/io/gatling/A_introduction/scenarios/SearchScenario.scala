package io.gatling.A_introduction.scenarios

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.A_introduction.processes.Search

object SearchScenario {

  /**
    * Search pages
    */
  val search: ScenarioBuilder =
    scenario("Search")
      .exec(Search.searchPageRequest(1))
      .pause(3)
      .exec(Search.searchPageRequest(2))
}
