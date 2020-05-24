package com.ats.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ats.constant.FieldsConstants;
import com.ats.dao.LoginDetail;
import com.ats.dto.impl.DbProviderImpl;
import com.ats.model.LoginModel;

public class LoginDetailsImpl implements LoginDetail {

	static Connection con;
	static PreparedStatement ps;
	
	@Override
	public LoginModel getLoginDetail(String userName, String pwd) {
		LoginModel model=new LoginModel();
		ResultSet rs=null;
		try{
			con=DbProviderImpl.getConn();
			ps=con.prepareStatement("select * from login where userName=? and pwd=?");
			ps.setString(1, userName);
			ps.setString(2, pwd);
			rs=ps.executeQuery();
			while(rs.next()){
				model.setUserName(rs.getString(FieldsConstants.USER_NAME));
				model.setPwd(rs.getString(FieldsConstants.PASSWORD));
				model.setUseRoles(rs.getString(FieldsConstants.ROLES_D));
				model.setFullName(rs.getString(FieldsConstants.FULL_NAME));
			}
			rs.close();
			ps.close();
			con.close();
		}catch(Exception e){
			e.printStackTrace();
			model.setError(e.getMessage());
		}
		return model ;
	}

	@Override
	public LoginModel getLoginDetail(String userName) {
		LoginModel model=new LoginModel();
		ResultSet rs=null;
		try{
			con=DbProviderImpl.getConn();
			ps=con.prepareStatement("select * from login where userName=?");
			ps.setString(1, userName);
			rs=ps.executeQuery();
			while(rs.next()){
				model.setUserName(rs.getString(FieldsConstants.USER_NAME));
				model.setPwd(rs.getString(FieldsConstants.PASSWORD));
				model.setUseRoles(rs.getString(FieldsConstants.ROLES_D));
				model.setFullName(rs.getString(FieldsConstants.FULL_NAME));
			}
			rs.close();
			ps.close();
			con.close();
		}catch(Exception e){
			e.printStackTrace();
			model.setError(e.getMessage());
		}
		return model;
	}

}
