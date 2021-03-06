package com.internousdev.ecsitea.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsitea.dao.MCategoryDAO;
import com.internousdev.ecsitea.dto.MCategoryDTO;
import com.internousdev.ecsitea.util.CommonUtility;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport implements SessionAware {

	private List<MCategoryDTO> mCategoryDTOList = new ArrayList<MCategoryDTO>();
	private String categoryId;
	private Map<String, Object> session;

	public String execute(){

		if(!(session.containsKey("loginId"))&&!(session.containsKey("tempUserId"))){
			CommonUtility commonUtility = new CommonUtility();
			session.put("tempUserId", commonUtility.getRandomValue());
		}

		if(!(session.containsKey("logined")))
			session.put("logined", 0);

		if(!(session.containsKey("mCategoryList"))){
			MCategoryDAO mCategoryDAO = new MCategoryDAO();
			mCategoryDTOList = mCategoryDAO.getMCategoryList();
			session.put("mCategoryDTOList", mCategoryDTOList);
		}

		return SUCCESS;
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
