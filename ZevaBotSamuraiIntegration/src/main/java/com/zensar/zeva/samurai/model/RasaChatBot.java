package com.zensar.zeva.samurai.model;

public class RasaChatBot {

	/**
	 * 
	 */
	public String sessionId;
	public String topic;
	public String token;
	public String query;

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	/*
	 * public String resolvedQuery; public String intentName; public String score;
	 * public String parameters; public String result; public String slot; public
	 * String action; public String actionInComplete; private ZevaResponseStatus
	 * status;
	 * 
	 * public String getResolvedQuery() { return resolvedQuery; }
	 * 
	 * public void setResolvedQuery(String resolvedQuery) { this.resolvedQuery =
	 * resolvedQuery; }
	 * 
	 * public String getIntentName() { return intentName; }
	 * 
	 * public void setIntentName(String intentName) { this.intentName = intentName;
	 * }
	 * 
	 * public String getScore() { return score; }
	 * 
	 * public void setScore(String score) { this.score = score; }
	 * 
	 * public String getParameters() { return parameters; }
	 * 
	 * public void setParameters(String parameters) { this.parameters = parameters;
	 * }
	 * 
	 * public String getResult() { return result; }
	 * 
	 * public void setResult(String result) { this.result = result; }
	 * 
	 * public String getSlot() { return slot; }
	 * 
	 * public void setSlot(String slot) { this.slot = slot; }
	 * 
	 * public String getAction() { return action; }
	 * 
	 * public void setAction(String action) { this.action = action; }
	 * 
	 * public String getActionInComplete() { return actionInComplete; }
	 * 
	 * public void setActionInComplete(String actionInComplete) {
	 * this.actionInComplete = actionInComplete; }
	 * 
	 * public ZevaResponseStatus getStatus() { return status; }
	 * 
	 * public void setStatus(ZevaResponseStatus status) { this.status = status; }
	 * 
	 * public String getSessionId() { return sessionId; }
	 * 
	 * public void setSessionId(String sessionId) { this.sessionId = sessionId; }
	 * 
	 * public String getTopic() { return topic; }
	 * 
	 * public void setTopic(String topic) { this.topic = topic; }
	 * 
	 * public String getToken() { return token; }
	 * 
	 * public void setToken(String token) { this.token = token; }
	 * 
	 * public String getQuery() { return query; }
	 * 
	 * public void setQuery(String query) { this.query = query; }
	 * 
	 * @Override public String toString() { return "RasaChatBot [sessionId=" +
	 * sessionId + ", topic=" + topic + ", token=" + token + ", query=" + query +
	 * ", resolvedQuery=" + resolvedQuery + ", intentName=" + intentName +
	 * ", score=" + score + ", parameters=" + parameters + ", result=" + result +
	 * ", slot=" + slot + ", action=" + action + ", actionInComplete=" +
	 * actionInComplete + ", status=" + status + "]"; }
	 */
	@Override
	public String toString() {
		return "RasaChatBot [sessionId=" + sessionId + ", topic=" + topic + ", token=" + token + ", query=" + query
				+ "]";
	}
}
