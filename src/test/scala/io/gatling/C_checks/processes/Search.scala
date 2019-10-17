package io.gatling.C_checks.processes

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder

object Search {

  private val uri = "/computers"
  private val nameQueryParamKey = "f"

  /**
    * Search computer by 'name' and check if the result contain 'fullName'
    * @note 'name' (String) and 'fullName' (String) variable must be in the session
    * @return search request
    */
  val searchNameRequest: HttpRequestBuilder =
    http("Search name")
      .get(uri)
      .queryParam(nameQueryParamKey, "${name}")
      .check(css("a:contains(${fullName})", "href").saveAs("computerUrl"))

  /**
    * Request a computer page
    * @note 'computerUrl' (String) must be in the session
    * @return computer page request
    */
  val searchComputerUrl: HttpRequestBuilder =
    http("Computer")
      .get("${computerUrl}")
}
