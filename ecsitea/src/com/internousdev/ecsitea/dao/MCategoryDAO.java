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
				MCategoryDTO dto = new MCategoryDTO();
				dto.setId(rs.getInt("id"));
				dto.setCategoryId(rs.getInt("category_id"));
				dto.setCategoryName(rs.getString("category_name"));
				dto.setCategoryDescription(rs.getString("category_description"));
				dto.setInsertDate(rs.getDate("insert_date"));
				dto.setUpdateDate(rs.getDate("update_date"));
				mCategoryDTOList.add(dto);
			}
			Iterator<MCategoryDTO> ite = mCategoryDTOList.iterator();
			if(!(ite.hasNext())){
				mCategoryDTOList = null;
			}


		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}

		return mCategoryDTOList;
	}


}
