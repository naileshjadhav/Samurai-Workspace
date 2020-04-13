package com.zensar.samurai.model;

public class SamuraiServiceDto {

	private Long id;
	private String serviceName;
	private String stageName;
	private Boolean installationStatus = false;
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
