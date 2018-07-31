package com.oreillyauto.projecttemplate.domain;

import java.util.Arrays;

import javax.naming.spi.DirStateFactory.Result;

public class RestResponse {
	public RestResponse() {
	}

	private String[] messages;
	private Result result;

	public String[] getMessages() {
		return messages;
	}

	public void setMessages(String[] messages) {
		this.messages = messages;
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "RestResponse [messages=" + Arrays.toString(messages) + ", result=" + result + "]";
	}
}
