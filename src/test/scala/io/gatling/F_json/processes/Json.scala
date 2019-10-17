package io.gatling.F_json.processes

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder

object Json {

  private val uri = "/posts"

  /**
    * @note 'title' (String) must be in the session
    * @return search request on a specified page
    */
  def searchJsonPayload(): HttpRequestBuilder =
    http(s"Search matching post")
      .get(uri)
      .check(jsonPath("$[?(@.title=='${title}')]").saveAs("payload"))
}
