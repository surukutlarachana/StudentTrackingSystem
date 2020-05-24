package com.ats.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ats.dao.StuClgDtlsDAO;
import com.ats.dto.impl.DbProviderImpl;
import com.ats.constant.FieldsConstants;

public class StuClgDtlsDAOImpl implements StuClgDtlsDAO {

	static Connection con;
	static PreparedStatement ps;
	@Override
	public List<String> getStudentDetails(String input) {
		List<String> studentIds=new ArrayList<String>();
		ResultSet rs=null;
		String []ary=input.split(",");
		try{
			con=DbProviderImpl.getConn();
			ps=con.prepareStatement("select studentid  from  stuclgdtls where collegename=? and collegecode=?");
			ps.setString(1, ary[0]);
			ps.setString(2, ary[1]);
			rs=ps.executeQuery();
			while(rs.next()){
				studentIds.add(rs.getString(FieldsConstants.STUDENT_ID));
			}
			
			rs.close();
			ps.close();
			con.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return studentIds;
	}

}
