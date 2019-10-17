package io.gatling.C_checks.processes

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder

object Edit {

  private val nameFormParam = "name"
  private val companyFormParam = "company"

  /**
    * @note 'computerUrl' (String) and 'fullName' (String) variables must be in the session
    * @return edit request
    */
  val editRequest: HttpRequestBuilder =
    http("Edit")
      .post("${computerUrl}")
      .formParam(nameFormParam, "${fullName}")
      .formParam(companyFormParam, "3")
}
