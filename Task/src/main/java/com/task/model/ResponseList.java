package com.task.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
/*@JsonRootName(value = "Success")*/
public class ResponseList {
@JsonProperty("Success")
	private List<Response> Success;

	@Override
public String toString() {
	return "ResponseList [Success=" + Success + "]";
}

	public ResponseList(List<Response> success) {
		super();
		Success = success;
	}

	public ResponseList() {
		super();
	}


	public List<Response> getSuccess() {
		return Success;
	}

	public void setSuccess(List<Response> success) {
		Success = success;
	}
}
