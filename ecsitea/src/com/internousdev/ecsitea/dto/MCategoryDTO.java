package com.internousdev.ecsitea.dto;

import java.util.Date;

public class MCategoryDTO {

	private int id;
	private int categoryId;
	private String categoryName;
	private String categoryDescription;
	private Date insertDate;
	private Date updateDate;
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
	 * categoryIdを取得します。
	 * @return categoryId
	 */
	public int getCategoryId() {
	    return categoryId;
	}
	/**
	 * categoryIdを設定します。
	 * @param categoryId categoryId
	 */
	public void setCategoryId(int categoryId) {
	    this.categoryId = categoryId;
	}
	/**
	 * categoryNameを取得します。
	 * @return categoryName
	 */
	public String getCategoryName() {
	    return categoryName;
	}
	/**
	 * categoryNameを設定します。
	 * @param categoryName categoryName
	 */
	public void setCategoryName(String categoryName) {
	    this.categoryName = categoryName;
	}
	/**
	 * categoryDescriptionを取得します。
	 * @return categoryDescription
	 */
	public String getCategoryDescription() {
	    return categoryDescription;
	}
	/**
	 * categoryDescriptionを設定します。
	 * @param categoryDescription categoryDescription
	 */
	public void setCategoryDescription(String categoryDescription) {
	    this.categoryDescription = categoryDescription;
	}
	/**
	 * insertDateを取得します。
	 * @return insertDate
	 */
	public Date getInsertDate() {
	    return insertDate;
	}
	/**
	 * insertDateを設定します。
	 * @param insertDate insertDate
	 */
	public void setInsertDate(Date insertDate) {
	    this.insertDate = insertDate;
	}
	/**
	 * updateDateを取得します。
	 * @return updateDate
	 */
	public Date getUpdateDate() {
	    return updateDate;
	}
	/**
	 * updateDateを設定します。
	 * @param updateDate updateDate
	 */
	public void setUpdateDate(Date updateDate) {
	    this.updateDate = updateDate;
	}

}
