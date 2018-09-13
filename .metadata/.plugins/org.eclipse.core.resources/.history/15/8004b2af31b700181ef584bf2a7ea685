package com.internousdev.ecsitea.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsitea.dao.MCategoryDAO;
import com.internousdev.ecsitea.dao.ProductInfoDAO;
import com.internousdev.ecsitea.dto.MCategoryDTO;
import com.internousdev.ecsitea.dto.PagenationDTO;
import com.internousdev.ecsitea.dto.ProductInfoDTO;
import com.internousdev.ecsitea.util.InputChecker;
import com.internousdev.ecsitea.util.Pagenation;
import com.opensymphony.xwork2.ActionSupport;

public class SearchItemAction extends ActionSupport implements SessionAware {

	private String categoryId;
	private String keywords;
	private String pageNo;
	private List<MCategoryDTO> mCategoryDTOList = new ArrayList<MCategoryDTO>();
	private List<String> keywordsErrorMessageList = new ArrayList<String>();
	private List<ProductInfoDTO> productInfoDTOList = new ArrayList<ProductInfoDTO>();
	private Map<String, Object> session;

	public String execute(){
		String result = ERROR;

		InputChecker innputChecker = new InputChecker();
		if(keywords==null){
			keywords = "";
		}
		keywordsErrorMessageList = innputChecker.doCheck("検索ワード", keywords, 0, 16, true, true, true, true, false, true, true);

		ProductInfoDAO pdao = new ProductInfoDAO();
		switch(categoryId){
		case "1":
			productInfoDTOList = pdao.getProductInfoListAll(keywords.replaceAll("　", " ").split(" "));
			result = SUCCESS;
			break;

		default:
			productInfoDTOList = pdao.getProductListByKeywords(keywords.replaceAll("　", " ").split(" "), categoryId);
			result = SUCCESS;
		}
		Iterator<ProductInfoDTO> ite = productInfoDTOList.iterator();
		if(!(ite.hasNext())){
			productInfoDTOList = null;
		}
		session.put("keywordsErrorMessageList", keywordsErrorMessageList);

		if(!(session.containsKey("mCategoryList"))){
			MCategoryDAO mcdao = new MCategoryDAO();
			mCategoryDTOList = mcdao.getMCategoryList();
			session.put("mCategoryDTOList", mCategoryDTOList);
		}

		if(!(productInfoDTOList==null)){
			Pagenation pagenation = new Pagenation();
			PagenationDTO pdto = new PagenationDTO();
			if(pageNo == null){
				pdto = pagenation.initialize(productInfoDTOList, 9);
			}else{
				pdto = pagenation.getPage(productInfoDTOList, 9, pageNo);
			}
			session.put("productInfoDTOList", pdto.getCurrentProductInfoPage());
			session.put("totalPageSize", pdto.getTotalPageSize());
			session.put("currentPageSize", pdto.getCurrentPageNo());
			session.put("totalRecordSize", pdto.getTotalRecordSize());
			session.put("startRecordNo", pdto.getStartRecordNo());
			session.put("endRecordNo", pdto.getEndRecordNo());
			session.put("previusPage", pdto.isHasPreviusPage());
			session.put("previusPageNo", pdto.getPreviusPageNo());
			session.put("nextPage", pdto.isHasNextPage());
			session.put("nextPageNo", pdto.getNextPageNo());
		}else{
			session.put("productInfoDTOList", null);
		}

		return result;
	}

	/**
	 * categoryIdを取得します。
	 * @return categoryId
	 */
	public String getCategoryId() {
	    return categoryId;
	}

	/**
	 * categoryIdを設定します。
	 * @param categoryId categoryId
	 */
	public void setCategoryId(String categoryId) {
	    this.categoryId = categoryId;
	}

	/**
	 * keywordsを取得します。
	 * @return keywords
	 */
	public String getKeywords() {
	    return keywords;
	}

	/**
	 * keywordsを設定します。
	 * @param keywords keywords
	 */
	public void setKeywords(String keywords) {
	    this.keywords = keywords;
	}

	/**
	 * pageNoを取得します。
	 * @return pageNo
	 */
	public String getPageNo() {
	    return pageNo;
	}

	/**
	 * pageNoを設定します。
	 * @param pageNo pageNo
	 */
	public void setPageNo(String pageNo) {
	    this.pageNo = pageNo;
	}

	/**
	 * mCategoryDTOListを取得します。
	 * @return mCategoryDTOList
	 */
	public List<MCategoryDTO> getmCategoryDTOList() {
	    return mCategoryDTOList;
	}

	/**
	 * mCategoryDTOListを設定します。
	 * @param mCategoryDTOList mCategoryDTOList
	 */
	public void setmCategoryDTOList(List<MCategoryDTO> mCategoryDTOList) {
	    this.mCategoryDTOList = mCategoryDTOList;
	}

	/**
	 * productInfoDTOListを取得します。
	 * @return productInfoDTOList
	 */
	public List<ProductInfoDTO> getProductInfoDTOList() {
	    return productInfoDTOList;
	}

	/**
	 * productInfoDTOListを設定します。
	 * @param productInfoDTOList productInfoDTOList
	 */
	public void setProductInfoDTOList(List<ProductInfoDTO> productInfoDTOList) {
	    this.productInfoDTOList = productInfoDTOList;
	}

	/**
	 * keywordsErrorMessageListを取得します。
	 * @return keywordsErrorMessageList
	 */
	public List<String> getKeywordsErrorMessageList() {
	    return keywordsErrorMessageList;
	}

	/**
	 * keywordsErrorMessageListを設定します。
	 * @param keywordsErrorMessageList keywordsErrorMessageList
	 */
	public void setKeywordsErrorMessageList(List<String> keywordsErrorMessageList) {
	    this.keywordsErrorMessageList = keywordsErrorMessageList;
	}

	/**
	 * sessionを取得します。
	 * @return session
	 */
	public Map<String,Object> getSession() {
	    return session;
	}

	/**
	 * sessionを設定します。
	 * @param session session
	 */
	public void setSession(Map<String,Object> session) {
	    this.session = session;
	}


}
