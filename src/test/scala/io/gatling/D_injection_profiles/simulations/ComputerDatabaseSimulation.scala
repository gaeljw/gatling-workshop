package io.gatling.D_injection_profiles.simulations

import scala.concurrent.duration._

import io.gatling.D_injection_profiles.scenarios.HomePageScenario
import io.gatling.core.Predef._
import io.gatling.http.Predef.http

class ComputerDatabaseSimulation extends Simulation {

  private val httpConf = http.baseUrl("http://computer-database.gatling.io")


  // CLOSED WORKLOAD

  setUp(
    HomePageScenario.homeScenario.inject(
      rampConcurrentUsers(0) to 20 during (10 seconds),
      constantConcurrentUsers(20) during (30 seconds),
      rampConcurrentUsers(20) to 0 during (10 seconds)
    )
  ).protocols(httpConf)


  // CAPACITY TEST

  /*setUp(
    HomePageScenario.homeScenario.inject(
      rampUsersPerSec(0) to 10 during (10 seconds),
      constantUsersPerSec(10) during (10 seconds),
      rampUsersPerSec(10) to 20 during (10 seconds),
      constantUsersPerSec(20) during (10 seconds),
      rampUsersPerSec(20) to 30 during (10 seconds),
      constantUsersPerSec(30) during (10 seconds)
    )
  ).protocols(httpConf)*/


  // STRESS TEST

  /*setUp(
    HomePageScenario.homeScenario.inject(
      constantUsersPerSec(5) during (5 seconds),
      atOnceUsers(30),
      constantUsersPerSec(5) during (20 seconds)
    )
  ).protocols(httpConf)*/


  // SOAK TEST

  /*setUp(
    HomePageScenario.homeScenario.inject(
      constantUsersPerSec(10) during (1 day)
    )
  ).protocols(httpConf)*/

}
