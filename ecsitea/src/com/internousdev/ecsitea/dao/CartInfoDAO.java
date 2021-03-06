package com.internousdev.ecsitea.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsitea.dto.CartInfoDTO;
import com.internousdev.ecsitea.util.DBConnector;

public class CartInfoDAO {

	public List<CartInfoDTO> getCartInfoDTOList(String loginId){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		List<CartInfoDTO> cartInfoDTOList = new ArrayList<CartInfoDTO>();

		String sql = "select"
				+" ci.id as id,"
				+" ci.user_id as user_id,"
				+" ci.temp_user_id as temp_user_id,"
				+" ci.product_id as product_id,"
				+" sum(ci.product_count) as product_count,"
				+" pi.price as price,"
				+" pi.regist_date as regist_date,"
				+" pi.update_date as update_date,"
				+" pi.product_name as product_name,"
				+" pi.product_name_kana as product_name_kana,"
				+" pi.product_description as product_description,"
				+" pi.category_id as category_id,"
				+" pi.image_file_path as image_file_path,"
				+" pi.image_file_name as image_file_name,"
				+" pi.release_date as release_date,"
				+" pi.release_company as release_company,"
				+" pi.status as status,"
				+" (sum(ci.product_count) * pi.price) as subtotal"
				+"from cart_info as ci"
				+"left join product_info as pi"
				+"on ci.product_id = pi.product_id"
				+"where ci.user_id = ?"
				+"group by product_id";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			System.out.println("cartinfodao-getcartinfodtolist:" + loginId);
			ps.setString(1, loginId);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				CartInfoDTO cartInfoDTO = new CartInfoDTO();
				cartInfoDTO.setId(rs.getInt("id"));
				cartInfoDTO.setUserId(rs.getString("user_id"));
				cartInfoDTO.setTempUserId(rs.getString("temp_user_id"));
				cartInfoDTO.setProductId(rs.getInt("product_id"));
				cartInfoDTO.setProductCount(rs.getInt("product_count"));
				cartInfoDTO.setPrice(rs.getInt("price"));
				cartInfoDTO.setRegistDate(rs.getDate("regist_date"));
				cartInfoDTO.setUpdateDate(rs.getDate("update_date"));
				cartInfoDTO.setProductName(rs.getString("product_name"));
				cartInfoDTO.setProductNameKana(rs.getString("product_name_kana"));
				cartInfoDTO.setProductDescription(rs.getString("product_description"));
				cartInfoDTO.setCategoryId(rs.getInt("category_id"));
				cartInfoDTO.setImageFilePath(rs.getString("image_file_path"));
				cartInfoDTO.setImageFileName(rs.getString("image_file_name"));
				cartInfoDTO.setReleaseDate(rs.getDate("release_date"));
				cartInfoDTO.setReleaseCompany(rs.getString("release_company"));
				cartInfoDTO.setStatus(rs.getString("status"));
				cartInfoDTO.setSubtotal(rs.getInt("subtotal"));
				cartInfoDTOList.add(cartInfoDTO);
			}

		}catch(SQLException e){
			e.printStackTrace();
		}

		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}

		return cartInfoDTOList;

	}

	public int getTotalPrice(){
		return 0;
	}

	public int regist(){
		return 0;
	}

	public int delete(){
		return 0;
	}

	public int deleteAll(){
		return 0;
	}

	public boolean isExistCartInfo(){
		return false;
	}

	public int linkToLoginId(String tempUserId, String loginId) {
		// TODO 自動生成されたメソッド・スタブ
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		int count = 0;
		String sql = "update cart_info set user_id=?, temp_user_id = null where temp_user_id=?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginId);
			ps.setString(2, tempUserId);
			count = ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}

		return count;
	}

}
