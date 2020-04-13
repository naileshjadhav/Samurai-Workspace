package com.zensar.samurai.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class SamuraiPathDto {

	private Long id;
	private String databasePath;
	private String integrationPath;
	private String deploymentPath;
	@NotNull
	@NotBlank
	private String pathName;

	public String getPathName() {
		return pathName;
	}

	public void setPathName(String pathName) {
		this.pathName = pathName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDatabasePath() {
		return databasePath;
	}

	public void setDatabasePath(String databasePath) {
		this.databasePath = databasePath;
	}

	public String getIntegrationPath() {
		return integrationPath;
	}

	public void setIntegrationPath(String integrationPath) {
		this.integrationPath = integrationPath;
	}

	public String getDeploymentPath() {
		return deploymentPath;
	}

	public void setDeploymentPath(String deploymentPath) {
		this.deploymentPath = deploymentPath;
	}

}
