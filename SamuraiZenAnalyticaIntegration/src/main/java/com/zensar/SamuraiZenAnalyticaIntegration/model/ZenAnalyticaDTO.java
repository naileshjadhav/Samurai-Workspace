package com.zensar.SamuraiZenAnalyticaIntegration.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ZenAnalyticaDTO {

	@NotNull
	@NotBlank
	public String event;

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

}
