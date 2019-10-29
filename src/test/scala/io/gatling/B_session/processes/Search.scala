package io.gatling.B_session.processes

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder

object Search {

  private val uri = "/computers"
  private val pageQueryParamKey = "p"

  /**
   * @note 'page' session variable must have been set to a String integer
   * @return search request on session specified page
   *         call an http get request on /computers where p is the variable in the session
   */
  def searchPageRequest(): HttpRequestBuilder = {
    http("My page ${page}")
      .get(uri)
      .queryParam(pageQueryParamKey, "${page}")
  }

  /**
   * @return execute search request on multiple specified pages without any addition on those requests
   *         iterate over pages and call searchPageRequest for each page
   */
  def searchPages(pages: Int*): ChainBuilder = {
    foreach(pages, "page") {
      exec(searchPageRequest())
    }
  }

  def searchPagesWithSession(): ChainBuilder = {
    foreach("${pages}", "page") {
      exec(searchPageRequest()).pause(2.seconds)
    }
  }
}
