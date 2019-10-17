package io.gatling.C_checks.processes

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder

object Search {

  private val uri = "/computers"
  private val nameQueryParamKey = "f"
  private val cssSelector = "a:contains(???)"

  /**
    * Search computer by 'name' and check if the result contain 'fullName', save the href
    * @note 'name' (String) and 'fullName' (String) variable must be in the session
    * @return search request
    */
  val searchNameRequest: HttpRequestBuilder =
    ???

  /**
    * Request a computer page, use the computer url you fetched in the searchNameRequest
    * @note 'computerUrl' (String) must be in the session
    * @return computer page request
    */
  val searchComputerUrl: HttpRequestBuilder =
    ???
}
