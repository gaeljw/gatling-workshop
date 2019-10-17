package io.gatling.C_checks.processes

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder

object Edit {

  private val nameFormParam = "name"
  private val companyFormParam = "company"

  /**
    * edit a computer with a post request on the url you retrieved earlier, set the name to fullName, and the company to 3
    * @note 'computerUrl' (String) and 'fullName' (String) variables must be in the session
    * @return edit request
    */
  val editRequest: HttpRequestBuilder =
    ???
}
