package com.zensar.SamuraiZenAnalyticaIntegration.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "samurai_rpa")
public class SamuraiRpa {

	@Id
	@Column(name = "samurai_rpa_id", length = 10)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long samuraiRpaId;
	@Column(name = "zeva_request_id", length = 20)
	private String zevaRequestId;
	@Column(name = "user_name", length = 20)
	private String userName;
	@Column(name = "user_email", length = 20)
	private String userEmail;
	@Column(name = "request_date_time")
	private LocalDateTime requestDateTime;
	@Column(name = "severity", length = 10)
	private String severity;
	@Column(name = "impact", length = 10)
	private String impact;
	@Column(name = "eform_id", length = 10)
	private Long eformId;
	@Column(name = "type_of_request", length = 10)
	private String typeOfRequest;
	@Column(name = "eform_status_by_platform", length = 20)
	private String eformStatusByPlatform;
	@Column(name = "eform_status_update_date")
	private LocalDateTime eformStatusUpdateDate;
	@Column(name = "platform_remarks", length = 20)
	private String platformRemarks;
	@Column(name = "db_connection_url", length = 50)
	private String dbConnectionUrl;
	@Column(name = "solution_type", length = 50)
	private String solutionType;
	@Column(name = "resolution_platform", length = 50)
	private String resolutionPlatform;
	@Column(name = "resolution_response", length = 1000)
	private String resolutionResponse;

	public String getSolutionType() {
		return solutionType;
	}

	public void setSolutionType(String solutionType) {
		this.solutionType = solutionType;
	}

	public String getResolutionPlatform() {
		return resolutionPlatform;
	}

	public void setResolutionPlatform(String resolutionPlatform) {
		this.resolutionPlatform = resolutionPlatform;
	}

	public String getResolutionResponse() {
		return resolutionResponse;
	}

	public void setResolutionResponse(String resolutionResponse) {
		this.resolutionResponse = resolutionResponse;
	}

	public String getDbConnectionUrl() {
		return dbConnectionUrl;
	}

	public void setDbConnectionUrl(String dbConnectionUrl) {
		this.dbConnectionUrl = dbConnectionUrl;
	}

	public Long getSamuraiRpaId() {
		return samuraiRpaId;
	}

	public void setSamuraiRpaId(Long samuraiRpaId) {
		this.samuraiRpaId = samuraiRpaId;
	}

	public String getZevaRequestId() {
		return zevaRequestId;
	}

	public void setZevaRequestId(String zevaRequestId) {
		this.zevaRequestId = zevaRequestId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public LocalDateTime getRequestDateTime() {
		return requestDateTime;
	}

	public void setRequestDateTime(LocalDateTime requestDateTime) {
		this.requestDateTime = requestDateTime;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public String getImpact() {
		return impact;
	}

	public void setImpact(String impact) {
		this.impact = impact;
	}

	public Long getEformId() {
		return eformId;
	}

	public void setEformId(Long eformId) {
		this.eformId = eformId;
	}

	public String getTypeOfRequest() {
		return typeOfRequest;
	}

	public void setTypeOfRequest(String typeOfRequest) {
		this.typeOfRequest = typeOfRequest;
	}

	public String getEformStatusByPlatform() {
		return eformStatusByPlatform;
	}

	public void setEformStatusByPlatform(String eformStatusByPlatform) {
		this.eformStatusByPlatform = eformStatusByPlatform;
	}

	public LocalDateTime getEformStatusUpdateDate() {
		return eformStatusUpdateDate;
	}

	public void setEformStatusUpdateDate(LocalDateTime eformStatusUpdateDate) {
		this.eformStatusUpdateDate = eformStatusUpdateDate;
	}

	public String getPlatformRemarks() {
		return platformRemarks;
	}

	public void setPlatformRemarks(String platformRemarks) {
		this.platformRemarks = platformRemarks;
	}

}
