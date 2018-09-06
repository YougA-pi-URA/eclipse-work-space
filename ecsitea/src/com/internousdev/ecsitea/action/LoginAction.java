package com.internousdev.ecsitea.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsitea.dao.CartInfoDAO;
import com.internousdev.ecsitea.dao.DestinationInfoDAO;
import com.internousdev.ecsitea.dao.MCategoryDAO;
import com.internousdev.ecsitea.dao.UserInfoDAO;
import com.internousdev.ecsitea.dto.DestinationInfoDTO;
import com.internousdev.ecsitea.dto.MCategoryDTO;
import com.internousdev.ecsitea.dto.UserInfoDTO;
import com.internousdev.ecsitea.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {

	private String categoryId;
	private String loginId;
	private String password;
	private boolean savedLoginId;

	private List<MCategoryDTO> mCategoryDTOList = new ArrayList<MCategoryDTO>();

	private List<String> loginIdErrorMessageList = new ArrayList<String>();
	private List<String> passwordErrorMessageList = new ArrayList<String>();

	private Map<String, Object> session;

	public String execute(){
		String result = ERROR;

		if(savedLoginId==true){
			session.put("savedLoginId", true);
			session.put("loginId", loginId);
		}else{
			session.put("savedLoginId", false);
			session.remove(loginId);
		}

		InputChecker ic = new InputChecker();
		loginIdErrorMessageList = ic.doCheck("ログインID", loginId, 1, 8, true, false, false, true, false, false, false);
		passwordErrorMessageList = ic.doCheck("パスワード", password, 1, 16, true, false, false, true, false, false, false);

		if(loginIdErrorMessageList.size()!=0
				&& passwordErrorMessageList.size()!=0){
			session.put("loginIdErrorMessageList", loginIdErrorMessageList);
			session.put("passwordErrorMessageList", passwordErrorMessageList);
			session.put("logined", 0);
		}

		if(!session.containsKey("mCategoryList")){
			MCategoryDAO mCategoryDAO = new MCategoryDAO();
			mCategoryDTOList = mCategoryDAO.getMCategoryList();
			session.put("mCategoryDTOList", mCategoryDTOList);
		}

		UserInfoDAO userInfoDAO = new UserInfoDAO();
		if(userInfoDAO.isExistUserInfo(loginId, password)){
			if(userInfoDAO.login(loginId, password) > 0){
				UserInfoDTO userInfoDTO = userInfoDAO.getUserInfo(loginId, password);
				session.put("loginId", userInfoDTO.getUserId());
				int count = 0;
				CartInfoDAO cartInfoDAO = new CartInfoDAO();

				count = cartInfoDAO.linkToLoginId(String.valueOf(session.get("tempUserId")),loginId);
				if(count > 0){
					DestinationInfoDAO destinationInfoDAO = new DestinationInfoDAO();
					try{
						List<DestinationInfoDTO> destinationInfoDTOList = new ArrayList<DestinationInfoDTO>();
						destinationInfoDTOList = destinationInfoDAO.getDestinationInfo(loginId);
						Iterator<DestinationInfoDTO> ite = destinationInfoDTOList.iterator();
						if(!(ite.hasNext()))
							destinationInfoDTOList = null;
						session.put("destinationInfoDTOList", destinationInfoDTOList);
					}catch(SQLException e){
						e.printStackTrace();
					}
				}else
					result = SUCCESS;
			}
			session.put("logined", 1);
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
	 * loginIdを取得します。
	 * @return loginId
	 */
	public String getLoginId() {
	    return loginId;
	}

	/**
	 * loginIdを設定します。
	 * @param loginId loginId
	 */
	public void setLoginId(String loginId) {
	    this.loginId = loginId;
	}

	/**
	 * passwordを取得します。
	 * @return password
	 */
	public String getPassword() {
	    return password;
	}

	/**
	 * passwordを設定します。
	 * @param password password
	 */
	public void setPassword(String password) {
	    this.password = password;
	}

	/**
	 * savedLoginIdを取得します。
	 * @return savedLoginId
	 */
	public boolean isSavedLoginId() {
	    return savedLoginId;
	}

	/**
	 * savedLoginIdを設定します。
	 * @param savedLoginId savedLoginId
	 */
	public void setSavedLoginId(boolean savedLoginId) {
	    this.savedLoginId = savedLoginId;
	}

	/**
	 * loginIdErrorMessageListを取得します。
	 * @return loginIdErrorMessageList
	 */
	public List<String> getLoginIdErrorMessageList() {
	    return loginIdErrorMessageList;
	}

	/**
	 * loginIdErrorMessageListを設定します。
	 * @param loginIdErrorMessageList loginIdErrorMessageList
	 */
	public void setLoginIdErrorMessageList(List<String> loginIdErrorMessageList) {
	    this.loginIdErrorMessageList = loginIdErrorMessageList;
	}

	/**
	 * passwordErrorMessageListを取得します。
	 * @return passwordErrorMessageList
	 */
	public List<String> getPasswordErrorMessageList() {
	    return passwordErrorMessageList;
	}

	/**
	 * passwordErrorMessageListを設定します。
	 * @param passwordErrorMessageList passwordErrorMessageList
	 */
	public void setPasswordErrorMessageList(List<String> passwordErrorMessageList) {
	    this.passwordErrorMessageList = passwordErrorMessageList;
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
