package io.gatling.B_session.scenarios

import java.util.concurrent.ThreadLocalRandom

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.B_session.processes.Search

object SearchScenario {

  /**
   * Search pages
   */
  /*val search: ScenarioBuilder =
    scenario("Search")
      .exec(Search.searchPages(randomizer.nextInt(0, 20)))*/

  /**
   * Search pages with session
   */
  val searchWithSession: ScenarioBuilder = {
    scenario("Search with session")
      .exec(session => {
        val randomizer = ThreadLocalRandom.current()
        val newSession = session.set("pages", Seq(randomizer.nextInt(0, 20)))
        newSession
      })
      .exec(Search.searchPagesWithSession())
      .exec(_.remove("pages"))
  }

}
