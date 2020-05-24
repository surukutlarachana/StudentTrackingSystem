package com.ats.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.ats.dao.*;
import com.ats.dto.impl.DbProviderImpl;
import com.ats.model.SaveDetailsModel;
import com.ats.constant.*;

public class SaveDAOImpl implements SaveDAO {

	private static Connection con;
	private static PreparedStatement ps;

	@Override
	public String saveDetails(SaveDetailsModel saveModel) {

		if (saveModel.getDesignation().equalsIgnoreCase(
				FieldsConstants.DIRECTORATE)) {
			return saveDirectorateDetails(saveModel);
		} else {
			return saveSpocDetails(saveModel);
		}
	}

	private String saveDirectorateDetails(SaveDetailsModel saveModel) {
		String status = null;
		try {
			con = DbProviderImpl.getConn();
			ps = con.prepareStatement("INSERT INTO DIRECTORATE VALUES(?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, saveModel.getFirstName());
			ps.setString(2, saveModel.getLastName());
			ps.setString(3, saveModel.getUniversity());
			ps.setString(4, saveModel.getDesignation());
			ps.setString(5, saveModel.getMobileNumber());
			ps.setString(11, saveModel.getEmail());
			ps.setString(6, saveModel.getFirstCollege());
			ps.setString(7, saveModel.getSecondCollege());
			ps.setString(8, saveModel.getThirdCollege());
			ps.setString(9, saveModel.getFourthCollege());
			ps.setString(10, saveModel.getCollegeName());
			if (ps.executeUpdate() > 0) {
				status=saveLoginDtls(saveModel.getMobileNumber(),
						saveModel.getEmail(), saveModel.getFirstName(),
						saveModel.getLastName(), FieldsConstants.DIRECTORATE);
				
			}
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	private String saveSpocDetails(SaveDetailsModel saveModel) {
		String status = null;
		try {
			con = DbProviderImpl.getConn();
			ps = con.prepareStatement("INSERT INTO COLLEGES VALUES(?,?,?,?,?,?,?)");
			ps.setString(1, saveModel.getFirstName());
			ps.setString(2, saveModel.getLastName());
			ps.setString(3, saveModel.getCollegeName());
			ps.setString(4, saveModel.getDesignation());
			ps.setString(5, saveModel.getMobileNumber());
			ps.setString(6, saveModel.getEmail());
			ps.setString(7, saveModel.getCollegeCode());
			if (ps.executeUpdate() > 0) {
				status= saveLoginDtls(saveModel.getMobileNumber(),
						saveModel.getEmail(), saveModel.getFirstName(),
						saveModel.getLastName(), FieldsConstants.COLLEGE);
			}
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	private String saveLoginDtls(String mobileNumber, String email,
			String firstName, String lastName, String role) {
		String fullName = String.join(" ", firstName, lastName);
		try {
			con = DbProviderImpl.getConn();
			ps = con.prepareStatement("INSERT INTO LOGIN VALUES(?,?,?,?)");
			ps.setString(1, email);
			ps.setString(2, mobileNumber);
			ps.setString(3, role);
			ps.setString(4, fullName);
			if (ps.executeUpdate() > 0) {
				return FieldsConstants.SUCCESS_STATUS;
			}
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return FieldsConstants.FAILED_STATUS;
	}

}
