package com.internousdev.ecsitea.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsitea.dto.UserInfoDTO;
import com.internousdev.ecsitea.util.DBConnector;

public class UserInfoDAO {

	public int createUser(){
		return 0;
	}

	public boolean isExistUserInfo(String loginId, String password) {
		// TODO 自動生成されたメソッド・スタブ
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		boolean result = false;
		String sql = "select count(*) as count from user_info where user_id=? and password=?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginId);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				if(rs.getInt("count") > 0)
					result = true;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return result;
	}

	public UserInfoDTO getUserInfo(String loginId, String password) {
		// TODO 自動生成されたメソッド・スタブ
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		UserInfoDTO userInfoDTO = new UserInfoDTO();
		String sql = "select * from user_info where user_id=? and password=?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginId);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				userInfoDTO.setId(rs.getInt("id"));
				userInfoDTO.setUserId(rs.getString("user_id"));
				userInfoDTO.setPassword(rs.getString("password"));
				userInfoDTO.setFamilyName(rs.getString("family_name"));
				userInfoDTO.setFirstName(rs.getString("first_name"));
				userInfoDTO.setFamilyNameKana(rs.getString("family_name_kana"));
				userInfoDTO.setSex(rs.getInt("sex"));
				userInfoDTO.setEmail(rs.getString("email"));
				userInfoDTO.setStatus(rs.getString("status"));
				userInfoDTO.setRegistDate(rs.getDate("regist_date"));
				userInfoDTO.setUpdateDate(rs.getDate("update_date"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}

		return userInfoDTO;
	}

	public UserInfoDTO getUserInfo(String loginId){
		return null;
	}

	public int resetPassword(){
		return 0;
	}

	public int login(String loginId, String password) {
		// TODO 自動生成されたメソッド・スタブ
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		int result = 0;
		String sql = "update user_info set logined=1 where user_id=? and password=?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginId);
			ps.setString(2, password);
			result = ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}

		return result;
	}

	public int logout(String loginId){
		return 0;
	}

	public String concealPassword(String password){
		String concealPassword = "";
		return concealPassword;
	}

}
