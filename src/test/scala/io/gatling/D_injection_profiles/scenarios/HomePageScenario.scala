package io.gatling.D_injection_profiles.scenarios

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder

import io.gatling.D_injection_profiles.processes.Homepage

object HomePageScenario {

  val homeScenario: ScenarioBuilder =
    scenario("Home")
      .exec(Homepage.home)
}
