package com.zensar.samurai.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "samurai_path")
public class SamuraiPath {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "path_id")
	private Long id;
	@Column(name = "databasepath", length = 500, nullable = true)
	private String databasePath;
	@Column(name = "integrationpath", length = 500, nullable = true)
	private String integrationPath;
	@Column(name = "deploymentpath", length = 500, nullable = true)
	private String deploymentPath;
	@Column(name = "path_name", length = 50, nullable = false)
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

	public void setId(Long id) {
		this.id = id;
	}

}
