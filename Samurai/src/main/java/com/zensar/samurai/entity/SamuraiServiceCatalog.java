package com.zensar.samurai.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "samurai_service")
public class SamuraiServiceCatalog {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "service_id")
	private Long id;
	@Column(name = "servicename", length = 100, nullable = false, unique = false)
	private String serviceName;
	@Column(name = "stage_name", length = 100, nullable = true)
	private String stageName;
	@Column(name = "installation_status", nullable = true, columnDefinition = "boolean default false")
	private Boolean installationStatus = false;
	@Column(name = "deployment_status", nullable = true, columnDefinition = "boolean default false")
	private Boolean deploymentStatus = false;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public Boolean getInstallationStatus() {
		return installationStatus;
	}

	public void setInstallationStatus(Boolean installationStatus) {
		this.installationStatus = installationStatus;
	}

	public Boolean getDeploymentStatus() {
		return deploymentStatus;
	}

	public void setDeploymentStatus(Boolean deploymentStatus) {
		this.deploymentStatus = deploymentStatus;
	}

	public String getStageName() {
		return stageName;
	}

	public void setStageName(String stageName) {
		this.stageName = stageName;
	}

}
