package io.gatling.A_introduction.processes

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder

object Search {

  private val uri = "/computers"
  private val pageQueryParamKey = "p"

  /**
   * make an http get request on /computers with a queryParam p
   *
   * @return search request on a specified page
   */
  def searchPageRequest(page: Int): HttpRequestBuilder = {
    http(s"page $page")
      .get(uri)
      .queryParam(pageQueryParamKey, page)
  }
}
