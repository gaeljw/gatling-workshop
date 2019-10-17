package io.gatling.B_session.scenarios

import java.util.concurrent.ThreadLocalRandom

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.B_session.processes.Search

object SearchScenario {

  val randomizer = ThreadLocalRandom.current()

  /**
    * Search pages
    */
  val search: ScenarioBuilder =
    scenario("Search")
      .exec(Search.searchPages(1, 2))

  /**
    * Search pages with session
    */
  /*val searchWithSession: ScenarioBuilder =
    ???*/
}
