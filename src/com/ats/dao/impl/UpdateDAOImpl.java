package com.ats.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ats.constant.FieldsConstants;
import com.ats.dao.UpdateDAO;
import com.ats.dto.impl.DbProviderImpl;
import com.ats.model.UpdateModel;

public class UpdateDAOImpl implements UpdateDAO {

	private static Connection con;
	private static PreparedStatement ps;

	@Override
	public String updateDtls(UpdateModel update) {
		String role = getLoginDetails(update);
		String status = null;
		if (role.equalsIgnoreCase(FieldsConstants.STUDENT)) {
			status = updateStudent(update);
		} else if (role.equalsIgnoreCase(FieldsConstants.DIRECTORATE)) {
			status = updateDirectorate(update);
		} else {
			status = updateSpoc(update);
		}
		return String.join(",", status, role);
	}

	private String updateStudent(UpdateModel update) {
		String status = null;
		try {
			con = DbProviderImpl.getConn();
			ps = con.prepareStatement("update register set EMAIL=?,MOBILENUMBER=?,EXCELLING=? WHERE ROLLNO=? ");
			ps.setString(1, update.getEmail());
			ps.setString(2, update.getMobileNumber());
			ps.setString(3, update.getExcelling());
			ps.setString(4, update.getUserName());
			if (ps.executeUpdate() > 0) {
				status = updateDts(update.getUserName(), update.getPwd(),"",FieldsConstants.STUDENT);
			}
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	private String updateDirectorate(UpdateModel update) {
		try {
			con = DbProviderImpl.getConn();
			ps = con.prepareStatement("UPDATE DIRECTORATE SET UNIVERSITY=?,DESIGNATION=?,MOBILENUMBER=?,EMAIL=?,FIRSTCOLLEGE=?,SECONDCOLLEGE=?,THIRDCOLLEGE=?,FOURTHCOLLEGE=?,CURRENTCOLLEGE=?");
			ps.setString(1, update.getUniversity());
			ps.setString(2, update.getDesignation());
			ps.setString(3, update.getMobileNumber());
			ps.setString(4, update.getEmail());
			ps.setString(5, update.getFirstCollege());
			ps.setString(6, update.getSecondCollege());
			ps.setString(7, update.getThirdCollege());
			ps.setString(8, update.getFourthCollege());
			ps.setString(9, update.getCurrentCollege());
			if(ps.executeUpdate()>0){
				return updateDts(update.getUserName(),update.getMobileNumber(),update.getEmail(),FieldsConstants.DIRECTORATE);
			}
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return FieldsConstants.FAILED_STATUS;
	}

	private String updateSpoc(UpdateModel update) {
		try {
			con = DbProviderImpl.getConn();
			ps = con.prepareStatement("UPDATE COLLEGES SET COLLEGENAME=?,DESIGNATION=?,MOBILENUMBER=?,EMAIL=?,COLLEGECODE=?");
			ps.setString(1, update.getCollegeName());
			ps.setString(2, update.getDesignation());
			ps.setString(3, update.getMobileNumber());
			ps.setString(4, update.getEmail());
			ps.setString(5, update.getCollegeCode());
			if(ps.executeUpdate()>0){
				return updateDts(update.getUserName(),update.getMobileNumber(),update.getEmail(),FieldsConstants.COLLEGE);
			}
			ps.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private String updateDts(String userName, String pwd,String email,String role) {
		try {
			con = DbProviderImpl.getConn();
			if(role.equalsIgnoreCase(FieldsConstants.STUDENT)){
			ps = con.prepareStatement("update login set PWD=? WHERE USERNAME=? ");
			ps.setString(1, pwd);
			ps.setString(2, userName);
			}
			else{
				ps = con.prepareStatement("update login set USERNAME=?, PWD=? WHERE ROLE=? and USERNAME=?");
				ps.setString(1, pwd);
				ps.setString(2, email);
				ps.setString(3, role);
				ps.setString(4, userName);
			}
			if (ps.executeUpdate() > 0) {
				return FieldsConstants.SUCCESS_STATUS;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return FieldsConstants.FAILED_STATUS;
	}

	private String getLoginDetails(UpdateModel update) {
		String role = null;
		try {
			con = DbProviderImpl.getConn();
			ps = con.prepareStatement("SELECT USEROLES FROM LOGIN WHERE USERNAME=?");
			ps.setString(1, update.getUserName());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				role = rs.getString(FieldsConstants.ROLES_D);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return role;
	}

}
