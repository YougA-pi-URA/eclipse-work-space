package com.internousdev.ecsitea.dto;

import java.util.Date;

public class DestinationInfoDTO {
	
	private int id;
	private String userId;
	private String familyName;
	private String firstName;
	private String familyNameKana;
	private String firstNameKana;
	private String email;
	private String telNumber;
	private String userAddress;
	private Date registDate;
	private Date UpdateDate;
	/**
	 * idを取得します。
	 * @return id
	 */
	public int getId() {
	    return id;
	}
	/**
	 * idを設定します。
	 * @param id id
	 */
	public void setId(int id) {
	    this.id = id;
	}
	/**
	 * userIdを取得します。
	 * @return userId
	 */
	public String getUserId() {
	    return userId;
	}
	/**
	 * userIdを設定します。
	 * @param userId userId
	 */
	public void setUserId(String userId) {
	    this.userId = userId;
	}
	/**
	 * familyNameを取得します。
	 * @return familyName
	 */
	public String getFamilyName() {
	    return familyName;
	}
	/**
	 * familyNameを設定します。
	 * @param familyName familyName
	 */
	public void setFamilyName(String familyName) {
	    this.familyName = familyName;
	}
	/**
	 * firstNameを取得します。
	 * @return firstName
	 */
	public String getFirstName() {
	    return firstName;
	}
	/**
	 * firstNameを設定します。
	 * @param firstName firstName
	 */
	public void setFirstName(String firstName) {
	    this.firstName = firstName;
	}
	/**
	 * familyNameKanaを取得します。
	 * @return familyNameKana
	 */
	public String getFamilyNameKana() {
	    return familyNameKana;
	}
	/**
	 * familyNameKanaを設定します。
	 * @param familyNameKana familyNameKana
	 */
	public void setFamilyNameKana(String familyNameKana) {
	    this.familyNameKana = familyNameKana;
	}
	/**
	 * firstNameKanaを取得します。
	 * @return firstNameKana
	 */
	public String getFirstNameKana() {
	    return firstNameKana;
	}
	/**
	 * firstNameKanaを設定します。
	 * @param firstNameKana firstNameKana
	 */
	public void setFirstNameKana(String firstNameKana) {
	    this.firstNameKana = firstNameKana;
	}
	/**
	 * emailを取得します。
	 * @return email
	 */
	public String getEmail() {
	    return email;
	}
	/**
	 * emailを設定します。
	 * @param email email
	 */
	public void setEmail(String email) {
	    this.email = email;
	}
	/**
	 * telNumberを取得します。
	 * @return telNumber
	 */
	public String getTelNumber() {
	    return telNumber;
	}
	/**
	 * telNumberを設定します。
	 * @param telNumber telNumber
	 */
	public void setTelNumber(String telNumber) {
	    this.telNumber = telNumber;
	}
	/**
	 * userAddressを取得します。
	 * @return userAddress
	 */
	public String getUserAddress() {
	    return userAddress;
	}
	/**
	 * userAddressを設定します。
	 * @param userAddress userAddress
	 */
	public void setUserAddress(String userAddress) {
	    this.userAddress = userAddress;
	}
	/**
	 * registDateを取得します。
	 * @return registDate
	 */
	public Date getRegistDate() {
	    return registDate;
	}
	/**
	 * registDateを設定します。
	 * @param registDate registDate
	 */
	public void setRegistDate(Date registDate) {
	    this.registDate = registDate;
	}
	/**
	 * UpdateDateを取得します。
	 * @return UpdateDate
	 */
	public Date getUpdateDate() {
	    return UpdateDate;
	}
	/**
	 * UpdateDateを設定します。
	 * @param UpdateDate UpdateDate
	 */
	public void setUpdateDate(Date UpdateDate) {
	    this.UpdateDate = UpdateDate;
	}

}
