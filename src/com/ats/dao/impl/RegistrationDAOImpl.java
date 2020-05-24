package com.ats.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ats.constant.FieldsConstants;
import com.ats.dao.RegistrationDAO;
import com.ats.dto.impl.DbProviderImpl;
import com.ats.model.RegistrationModel;

public class RegistrationDAOImpl implements RegistrationDAO {

	private static Connection con;
	private static PreparedStatement ps;

	
	@Override
	public String setRegDetails(RegistrationModel model) {
		int status=0;
		String message=null;
		try{
			con=DbProviderImpl.getConn();
			ps=con.prepareStatement("insert into register values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, model.getRollno());
			ps.setString(2, model.getFirstName());
			ps.setString(3, model.getLastName());
			ps.setString(4, model.getDob());
			ps.setString(5, model.getEmail());
			ps.setString(6, model.getMobileNumber());
			ps.setString(7, model.getCollegeName());
			ps.setString(8, model.getBranch());
			ps.setString(9, model.getCourse());
			ps.setString(10, model.getStartYear());
			ps.setString(11, model.getEndYear());
			ps.setString(12, model.getExcelling());
			ps.setString(13, model.getCollegeCode());
			ps.setString(14, model.getVerified());
			status=ps.executeUpdate();
			if(status>0){
				message=FieldsConstants.SUCCESS_STATUS;
						
			}
			ps.close();
			con.close();
		}catch(Exception e){
			e.printStackTrace();
			message=e.getMessage();  
		}
		return message;
	}

	@Override
	public List<RegistrationModel> getRegDetails(String studentId) {
		RegistrationModel rmodel=new RegistrationModel();
		List<RegistrationModel>dataList=new ArrayList<>();
		try{
			con=DbProviderImpl.getConn();
			ps=con.prepareStatement("select *from register where rollno=?");
			ps.setString(1, studentId);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				rmodel.setFirstName(rs.getString(FieldsConstants.FIRST_NAME));
				rmodel.setLastName(rs.getString(FieldsConstants.LAST_NAME));
				rmodel.setRollno(rs.getString(FieldsConstants.ROLL_NO));
				rmodel.setDob(rs.getString(FieldsConstants.DOB_C));
				rmodel.setEmail(rs.getString(FieldsConstants.EMAIL_D));
				rmodel.setMobileNumber(rs.getString(FieldsConstants.MOBILE_NUMBER));
				rmodel.setCollegeName(rs.getString(FieldsConstants.COLLEGE_NAME));
				rmodel.setBranch(rs.getString(FieldsConstants.BRANCH_C));
				rmodel.setCourse(rs.getString(FieldsConstants.COURSE_C));
				rmodel.setStartYear(rs.getString(FieldsConstants.START_YEAR));
				rmodel.setEndYear(rs.getString(FieldsConstants.END_YEAR));
				rmodel.setExcelling(rs.getString(FieldsConstants.EXCELLING_IN));
				rmodel.setCollegeCode(rs.getString(FieldsConstants.COLLEGE_CODE));
				}
			dataList.add(rmodel);
			rs.close();
			ps.close();
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return dataList;
	}
}
