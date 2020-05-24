package com.ats.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ats.constant.FieldsConstants;
import com.ats.dao.SpocDAO;
import com.ats.dto.impl.DbProviderImpl;
import com.ats.model.RegistrationModel;
import com.ats.model.SpocModel;

public class SpocDAOImpl implements SpocDAO {

	static Connection con;
	static PreparedStatement ps;
	@Override
	public String getSpocDetails(String userName) {
		String  result=null;
		ResultSet rs=null;
		try{
			con=DbProviderImpl.getConn();
			ps=con.prepareStatement("select collegename,collegecode from colleges where email=?");
			ps.setString(1, userName);
			 rs=ps.executeQuery();
			while(rs.next()){
				result=String.join(",",rs.getString(FieldsConstants.COLLEGE_NAME),rs.getString(FieldsConstants.COLLEGE_CODE));
				
			}
			rs.close();
			ps.close();
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public List<RegistrationModel> getRegisterStudentDetails(List<String> studentIds) {
		List <RegistrationModel>dataList=new ArrayList<>();
		ResultSet rs=null;
		try{
			con=DbProviderImpl.getConn();
			for(String studentId:studentIds){
				RegistrationModel rmodel=new RegistrationModel();
			ps=con.prepareStatement("select * from register where rollno=? and verified=?");
			ps.setString(1, studentId);
			ps.setString(2, String.valueOf(FieldsConstants.FALSE));
			
			rs =ps.executeQuery();
			 
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
				rmodel.setVerified(rs.getString(FieldsConstants.VERIFY));
				dataList.add(rmodel);
			}
			}
			rs.close();
			ps.close();
			con.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return !dataList.isEmpty() ?dataList:new ArrayList<>();
	}
	
	@Override
	public String verifyStudent(String studentid,String mbno,String firstName,String lastName) {
		int count=0;
		String status=null;
		try{
			con=DbProviderImpl.getConn();
			ps=con.prepareStatement("update register set verified=? where rollno=?");
			ps.setString(1, String.valueOf(FieldsConstants.TURE));
			ps.setString(2, studentid);
			count=ps.executeUpdate();
			if(count>0){
				status=setStudentLogin(studentid,mbno,firstName,lastName);
			}
			ps.close();
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return status;
	}

	private String setStudentLogin(String studentid,String mbno,String firstName,String lastName) {
		int count=0;
		String status=null;
		String fullName=String.join(" ", firstName,lastName);
	try{
		con=DbProviderImpl.getConn();
		ps=con.prepareStatement("insert into  login values (?,?,?,?)");
		ps.setString(1, studentid);
		ps.setString(2, mbno);
		ps.setString(3, FieldsConstants.STUDENT);
		ps.setString(4, fullName);
		count=ps.executeUpdate();
		if(count>0){
			status=FieldsConstants.SUCCESS_STATUS;
		}
		ps.close();
		con.close();
	}catch(Exception e){
		e.printStackTrace();
	}
		return status !=null ? status :FieldsConstants.FAILED_STATUS;
	}
	
	@Override
	public String saveSpocDtls(SpocModel spocDetails) {
		int count=0;
		String status=null;
		try{
			con=DbProviderImpl.getConn();
			ps=con.prepareStatement("INSERT INTO COLLEGES VALUES(?,?,?,?,?,?,?)");
			ps.setString(1, spocDetails.getFirstName());
			ps.setString(2, spocDetails.getLastName());
			ps.setString(3, spocDetails.getCollegeName());
			ps.setString(4, spocDetails.getDesignation());
			ps.setString(5, spocDetails.getMobileNumber());
			ps.setString(6, spocDetails.getEmail());
			ps.setString(7, spocDetails.getCollegeCode());
			count=ps.executeUpdate();
			if(count>0){
				status=saveSpoc(spocDetails.getFirstName(),spocDetails.getLastName(),spocDetails.getEmail(),spocDetails.getMobileNumber());
			}
				ps.close();
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return status;
	}
	private String saveSpoc(String firstName, String lastName, String email,
			String mobileNumber) {
		int count=0;
		String status=null;
		String fullName=String.join(" ", firstName,lastName);
		try{
			con=DbProviderImpl.getConn();
			ps=con.prepareStatement("INSERT INTO LOGIN VALUES(?,?,?,?)");
			ps.setString(1, email);
			ps.setString(2, mobileNumber);
			ps.setString(3, FieldsConstants.COLLEGE);
			ps.setString(4, fullName);
			count=ps.executeUpdate();
			if(count>0){
				status=FieldsConstants.SUCCESS_STATUS;
			}
			ps.close();
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return status !=null ? status : FieldsConstants.FAILED_STATUS;
	}
	
	public String savePosts(String fullname, String description, long time,
			String collegeName) {
		try{
			con=DbProviderImpl.getConn();
			ps=con.prepareStatement("INSERT INTO POSTDETAILS VALUES(?,?,?,?)");
			ps.setString(1, fullname);
			ps.setString(2, description);
			ps.setString(3, String.valueOf(time));
			ps.setString(4, collegeName);
			if(ps.executeUpdate()>0){
				return FieldsConstants.SUCCESS_STATUS;
			}
			ps.close();
			con.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return FieldsConstants.FAILED_STATUS;
	}
}
