package com.oreillyauto.projecttemplate.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {
	public Response() {
	}

	@JsonProperty("RestResponse")
	private RestResponse restResponse;

	public RestResponse getRestResponse() {
		return restResponse;
	}

	public void setRestResponse(RestResponse restResponse) {
		this.restResponse = restResponse;
	}

	@Override
	public String toString() {
		return "Response [RestResponse=" + restResponse + "]";
	}
}
