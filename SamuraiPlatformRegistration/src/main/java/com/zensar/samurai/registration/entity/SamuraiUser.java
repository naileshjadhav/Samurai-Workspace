package com.zensar.samurai.registration.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "samurai_user")
public class SamuraiUser {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id", length = 20, columnDefinition = "default 1000")
	private Long userId;
	@Column(name = "user_name", length = 50, nullable = false)
	private String userName;
	@Column(name = "user_email", length = 50, nullable = false)
	private String userEmail;
	@Column(name = "user_organisation", length = 50, nullable = false)
	private String userOrganisation;
	@Column(name = "user_mobile", length = 12, nullable = true)
	private String userMobileNo;
	private LocalDateTime registrationDate;
	@Column(name = "user_password", length = 500, nullable = false)
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
