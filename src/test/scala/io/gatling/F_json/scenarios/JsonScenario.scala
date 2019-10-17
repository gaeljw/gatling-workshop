package io.gatling.F_json.scenarios

import io.gatling.F_json.processes.Json
import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder

object JsonScenario {

  /**
    * Search json payload
    */
  val search: ScenarioBuilder =
    scenario("Search")
      .exec(session => session.set("title", "qui est esse"))
      .exec(Json.searchJsonPayload())
      .exec(session => session.remove("title"))
      .exitHereIfFailed
      .exec(session => session.remove("payload"))
}
