package com.internousdev.ecsitea.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsitea.dto.ProductInfoDTO;
import com.internousdev.ecsitea.util.DBConnector;

public class ProductInfoDAO {

	public List<ProductInfoDTO> getProductInfoList(){
		return null;
	}

	public ProductInfoDTO getProductInfo(int productId){
		return null;

	}

	public List<ProductInfoDTO> getProductListByCategoryId(int categoryId, int productId, int limitOffset, int limitRowCount){
		return null;

	}

	public List<ProductInfoDTO> getProductInfoListAll(String[] keywordsList) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		List<ProductInfoDTO> productInfoDTOList = new ArrayList<ProductInfoDTO>();
		String sql = "select * from product_info where";
		boolean initializeFlag = true;
		for(String keyword : keywordsList){
			if(initializeFlag){
				sql += " (product_name like '%" + keyword + "%' or product_name_kana like '%" + keyword + "%')";
				initializeFlag = false;
			}else{
				sql += " and (product_name like '%" + keyword + "%' or product_name_kana like '%" + keyword + "%')";
			}
		}
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				ProductInfoDTO pdto = new ProductInfoDTO();
				pdto.setId(rs.getInt("id"));
				pdto.setProductId(rs.getInt("product_id"));
				pdto.setProductName(rs.getString("product_name"));
				pdto.setProductNameKana(rs.getString("product_name_kana"));
				pdto.setProductDescription(rs.getString("product_description"));
				pdto.setCategoryId(rs.getInt("category_id"));
				pdto.setPrice(rs.getInt("price"));
				pdto.setImageFilePath(rs.getString("image_file_path"));
				pdto.setImageFileName(rs.getString("image_file_name"));
				pdto.setReleaseDate(rs.getDate("release_date"));
				pdto.setReleaseCompany(rs.getString("release_company"));
				pdto.setStatus(rs.getInt("status"));
				pdto.setRegistDate(rs.getDate("regist_date"));
				pdto.setUpdateDate(rs.getDate("update_date"));
				productInfoDTOList.add(pdto);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return productInfoDTOList;
	}

	public List<ProductInfoDTO> getProductListByKeywords(String[] keywordsList, String categoryId){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		List<ProductInfoDTO> productInfoDTOList = new ArrayList<ProductInfoDTO>();
		String sql = "select * from product_info where";
		boolean initializeFlag = true;
		for(String keyword : keywordsList){
			if(initializeFlag){
				sql += " category_id=" + categoryId + " and (product_name like '%" + keyword + "%' or product_name_kana like '%" + keyword + "%')";
				initializeFlag = false;
			}else{
				sql += " and (product_name like '%" + keyword + "%' or product_name_kana like '%" + keyword + "%')";
			}
		}
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				ProductInfoDTO pdto = new ProductInfoDTO();
				pdto.setId(rs.getInt("id"));
				pdto.setProductId(rs.getInt("product_id"));
				pdto.setProductName(rs.getString("product_name"));
				pdto.setProductNameKana(rs.getString("product_name_kana"));
				pdto.setProductDescription(rs.getString("product_description"));
				pdto.setCategoryId(rs.getInt("category_id"));
				pdto.setPrice(rs.getInt("price"));
				pdto.setImageFilePath(rs.getString("image_file_path"));
				pdto.setImageFileName(rs.getString("image_file_name"));
				pdto.setReleaseDate(rs.getDate("release_date"));
				pdto.setReleaseCompany(rs.getString("release_company"));
				pdto.setStatus(rs.getInt("status"));
				pdto.setRegistDate(rs.getDate("regist_date"));
				pdto.setUpdateDate(rs.getDate("update_date"));
				productInfoDTOList.add(pdto);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return productInfoDTOList;

	}

}
