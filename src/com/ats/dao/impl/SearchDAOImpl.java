package com.ats.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ats.constant.FieldsConstants;
import com.ats.dao.SearchDAO;
import com.ats.dto.impl.DbProviderImpl;
import com.ats.model.RegistrationModel;
import com.ats.model.SearchModel;

public class SearchDAOImpl implements SearchDAO{

	static Connection con;
	static PreparedStatement ps;
	
	@Override
	public List<RegistrationModel> getDetails(SearchModel model) {
		List<RegistrationModel>dataList=new ArrayList<>();
		try{
			con=DbProviderImpl.getConn();
			ps=con.prepareStatement("SELECT *FROM REGISTER WHERE COLLEGENAME=? OR STARTYEAR=? OR ENDYEAR=? OR BRANCH=? OR COLLEGECODE=?");
			ps.setString(1, model.getCollegeName());
			ps.setString(2, model.getStartYear());
			ps.setString(3, model.getEndYear());
			ps.setString(4, model.getBranch());
			ps.setString(5,model.getCollegCode());
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				RegistrationModel rmodel=new RegistrationModel();
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
				dataList.add(rmodel);
			}
			
			rs.close();
			ps.close();
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return dataList;
	}

}
