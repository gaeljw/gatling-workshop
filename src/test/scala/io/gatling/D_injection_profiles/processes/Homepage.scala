package io.gatling.D_injection_profiles.processes

import io.gatling.core.Predef._
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.Predef._

object Homepage {

  private val uri = "/"

  val home: ChainBuilder =
    exec(
      http("Home").get(uri)
    ).pause(3)
}
