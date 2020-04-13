package com.zensar.zeva.samurai.model;

public class Conversation {

	private String message;
	private String username;
	private String topic;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	@Override
	public String toString() {
		return "Conversation [message=" + message + ", username=" + username + ", topic=" + topic + "]";
	}

}
