package com.internousdev.ecsitea.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.internousdev.ecsitea.dto.MCategoryDTO;
import com.internousdev.ecsitea.util.DBConnector;

public class MCategoryDAO {

	public List<MCategoryDTO> getMCategoryList(){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		List<MCategoryDTO> mCategoryDTOList = new ArrayList<MCategoryDTO>();
		String sql = "select * from m_category";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				MCategoryDTO mCategoryDTO = new MCategoryDTO();
				mCategoryDTO.setId(rs.getInt("id"));
				mCategoryDTO.setCategoryId(rs.getInt("category_id"));
				mCategoryDTO.setCategoryName(rs.getString("category_name"));
				mCategoryDTO.setCategoryDescription(rs.getString("category_description"));
				mCategoryDTO.setInsertDate(rs.getDate("insert_date"));
				mCategoryDTO.setUpdateDate(rs.getDate("update_date"));
			}
			Iterator<MCategoryDTO> ite = mCategoryDTOList.iterator();
			if(!(ite.hasNext()))
				mCategoryDTOList = null;
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}

		return mCategoryDTOList ;
	}


}
