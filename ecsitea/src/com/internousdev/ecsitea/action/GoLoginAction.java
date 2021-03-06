package com.internousdev.ecsitea.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsitea.dao.MCategoryDAO;
import com.internousdev.ecsitea.dto.MCategoryDTO;
import com.opensymphony.xwork2.ActionSupport;

public class GoLoginAction extends ActionSupport implements SessionAware {

	private String categoryId;
	private List<MCategoryDTO> mCategoryDTOList = new ArrayList<MCategoryDTO>();
	private Map<String, Object> session;

	public String execute(){
		if(!session.containsKey("mCategoryDTOList")){
			MCategoryDAO mCategoryDAO = new MCategoryDAO();
			mCategoryDTOList = mCategoryDAO.getMCategoryList();
			session.put("mCategoryDTOList", mCategoryDTOList);
		}
		session.put("loginIdErrorMessageList", "");
		session.put("passwordErrorMessageList", "");
		return SUCCESS;
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
