package io.gatling.C_checks.processes

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder

object Search {

  private val uri = "/computers"
  private val nameQueryParamKey = "f"
  private val cssSelector = "a:contains(${fullName})"

  /**
   * Search computer by 'name' and check if the result contain 'fullName', save the href
   *
   * @note 'name' (String) and 'fullName' (String) variable must be in the session
   * @return search request
   */
  val searchNameRequest: HttpRequestBuilder = {
    http("Search for ${name}")
      .get(uri)
      .queryParam(nameQueryParamKey, "${name}")
      .check(
        css(cssSelector, "href").saveAs("computerUrl")
      )
  }

  /**
   * Request a computer page, use the computer url you fetched in the searchNameRequest
   *
   * @note 'computerUrl' (String) must be in the session
   * @return computer page request
   */
  val searchComputerUrl: HttpRequestBuilder = {
    http("Get computer ${name}")
      .get("${computerUrl}")
  }
}
