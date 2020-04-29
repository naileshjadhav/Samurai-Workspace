package com.zensar.samurai.registration.model;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class SamuraiUserDto {

	@NotBlank
	@NotNull
	private String userName;
	private Long userId;
	@NotBlank
	@NotNull
	private String userEmail;
	@NotBlank
	@NotNull
	private String userOrganisation;
	private String userMobileNo;
	private LocalDateTime registrationDate;
	private String userPassword;

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public LocalDateTime getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDateTime registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserOrganisation() {
		return userOrganisation;
	}

	public void setUserOrganisation(String userOrganisation) {
		this.userOrganisation = userOrganisation;
	}

	public String getUserMobileNo() {
		return userMobileNo;
	}

	public void setUserMobileNo(String userMobileNo) {
		this.userMobileNo = userMobileNo;
	}

}