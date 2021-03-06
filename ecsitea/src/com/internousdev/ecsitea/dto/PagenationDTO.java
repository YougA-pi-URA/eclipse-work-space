package com.internousdev.ecsitea.dto;

import java.util.ArrayList;
import java.util.List;

public class PagenationDTO {

	private int totalPageSize;
	private int currentPageNo;
	private int totalRecordSize;
	private int startRecordNo;
	private int endRecordNo;
	private List<Integer> pageNumberList = new ArrayList<Integer>();
	private List<ProductInfoDTO> currentProductInfoPage;
	private boolean hasNextPage;
	private boolean hasPreviusPage;
	private int nextPageNo;
	private int previusPageNo;
	/**
	 * totalPageSizeを取得します。
	 * @return totalPageSize
	 */
	public int getTotalPageSize() {
	    return totalPageSize;
	}
	/**
	 * totalPageSizeを設定します。
	 * @param totalPageSize totalPageSize
	 */
	public void setTotalPageSize(int totalPageSize) {
	    this.totalPageSize = totalPageSize;
	}
	/**
	 * currentPageNoを取得します。
	 * @return currentPageNo
	 */
	public int getCurrentPageNo() {
	    return currentPageNo;
	}
	/**
	 * currentPageNoを設定します。
	 * @param currentPageNo currentPageNo
	 */
	public void setCurrentPageNo(int currentPageNo) {
	    this.currentPageNo = currentPageNo;
	}
	/**
	 * totalRecordSizeを取得します。
	 * @return totalRecordSize
	 */
	public int getTotalRecordSize() {
	    return totalRecordSize;
	}
	/**
	 * totalRecordSizeを設定します。
	 * @param totalRecordSize totalRecordSize
	 */
	public void setTotalRecordSize(int totalRecordSize) {
	    this.totalRecordSize = totalRecordSize;
	}
	/**
	 * startRecordNoを取得します。
	 * @return startRecordNo
	 */
	public int getStartRecordNo() {
	    return startRecordNo;
	}
	/**
	 * startRecordNoを設定します。
	 * @param startRecordNo startRecordNo
	 */
	public void setStartRecordNo(int startRecordNo) {
	    this.startRecordNo = startRecordNo;
	}
	/**
	 * endRecordNoを取得します。
	 * @return endRecordNo
	 */
	public int getEndRecordNo() {
	    return endRecordNo;
	}
	/**
	 * endRecordNoを設定します。
	 * @param endRecordNo endRecordNo
	 */
	public void setEndRecordNo(int endRecordNo) {
	    this.endRecordNo = endRecordNo;
	}
	/**
	 * pageNumberListを取得します。
	 * @return pageNumberList
	 */
	public List<Integer> getPageNumberList() {
	    return pageNumberList;
	}
	/**
	 * pageNumberListを設定します。
	 * @param pageNumberList pageNumberList
	 */
	public void setPageNumberList(List<Integer> pageNumberList) {
	    this.pageNumberList = pageNumberList;
	}
	/**
	 * currentProductInfoPageを取得します。
	 * @return currentProductInfoPage
	 */
	public List<ProductInfoDTO> getCurrentProductInfoPage() {
	    return currentProductInfoPage;
	}
	/**
	 * currentProductInfoPageを設定します。
	 * @param currentProductInfoPage currentProductInfoPage
	 */
	public void setCurrentProductInfoPage(List<ProductInfoDTO> currentProductInfoPage) {
	    this.currentProductInfoPage = currentProductInfoPage;
	}
	/**
	 * hasNextPageを取得します。
	 * @return hasNextPage
	 */
	public boolean isHasNextPage() {
	    return hasNextPage;
	}
	/**
	 * hasNextPageを設定します。
	 * @param hasNextPage hasNextPage
	 */
	public void setHasNextPage(boolean hasNextPage) {
	    this.hasNextPage = hasNextPage;
	}
	/**
	 * hasPreviusPageを取得します。
	 * @return hasPreviusPage
	 */
	public boolean isHasPreviusPage() {
	    return hasPreviusPage;
	}
	/**
	 * hasPreviusPageを設定します。
	 * @param hasPreviusPage hasPreviusPage
	 */
	public void setHasPreviusPage(boolean hasPreviusPage) {
	    this.hasPreviusPage = hasPreviusPage;
	}
	/**
	 * nextPageNoを取得します。
	 * @return nextPageNo
	 */
	public int getNextPageNo() {
	    return nextPageNo;
	}
	/**
	 * nextPageNoを設定します。
	 * @param nextPageNo nextPageNo
	 */
	public void setNextPageNo(int nextPageNo) {
	    this.nextPageNo = nextPageNo;
	}
	/**
	 * previusPageNoを取得します。
	 * @return previusPageNo
	 */
	public int getPreviusPageNo() {
	    return previusPageNo;
	}
	/**
	 * previusPageNoを設定します。
	 * @param previusPageNo previusPageNo
	 */
	public void setPreviusPageNo(int previusPageNo) {
	    this.previusPageNo = previusPageNo;
	}

}
