package com.zensar.SamuraiZenAnalyticaIntegration.model;

public class SamuraiAnalyticaDto {

	private Long samuraiAnalyticaId;
	private String dbConnectionUrl;
	private String solutionType;
	private String resolutionPlatform;
	private String resolutionResponse;
	private Long resolutionID;
	private Long resolutionRank;
	private SamuraiRpaDto samuraiRpaDto;

	public SamuraiRpaDto getSamuraiRpaDto() {
		return samuraiRpaDto;
	}

	public void setSamuraiRpaDto(SamuraiRpaDto samuraiRpaDto) {
		this.samuraiRpaDto = samuraiRpaDto;
	}

	public Long getSamuraiAnalyticaId() {
		return samuraiAnalyticaId;
	}

	public void setSamuraiAnalyticaId(Long samuraiAnalyticaId) {
		this.samuraiAnalyticaId = samuraiAnalyticaId;
	}

	public Long getResolutionID() {
		return resolutionID;
	}

	public void setResolutionID(Long resolutionID) {
		this.resolutionID = resolutionID;
	}

	public Long getResolutionRank() {
		return resolutionRank;
	}

	public void setResolutionRank(Long resolutionRank) {
		this.resolutionRank = resolutionRank;
	}

	public String getResolutionResponse() {
		return resolutionResponse;
	}

	public void setResolutionResponse(String resolutionResponse) {
		this.resolutionResponse = resolutionResponse;
	}

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

	public String getDbConnectionUrl() {
		return dbConnectionUrl;
	}

	public void setDbConnectionUrl(String dbConnectionUrl) {
		this.dbConnectionUrl = dbConnectionUrl;
	}

}
