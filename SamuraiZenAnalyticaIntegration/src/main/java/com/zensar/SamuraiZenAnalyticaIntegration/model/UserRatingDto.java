package com.zensar.SamuraiZenAnalyticaIntegration.model;

public class UserRatingDto {

	private Long responseId;
	private String response;
	int feedback; // 1- positive Feedback 0- Negative Feedback

	public Long getResponseId() {
		return responseId;
	}

	public void setResponseId(Long responseId) {
		this.responseId = responseId;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public int getFeedback() {
		return feedback;
	}

	public void setFeedback(int feedback) {
		this.feedback = feedback;
	}

}
