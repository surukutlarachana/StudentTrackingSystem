package com.ats.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ats.constant.FieldsConstants;
import com.ats.dao.PostDetailsDAO;
import com.ats.dto.impl.DbProviderImpl;
import com.ats.model.Post;

public class PostsDetailImpl implements PostDetailsDAO {

	private static Connection con;
	private static PreparedStatement ps;

	@Override
	public List<Post> getPosts() {
		List<Post>postDtls=new ArrayList<>();
		try{
			con=DbProviderImpl.getConn();
			ps=con.prepareStatement("select *from postdetails");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				long time=Long.valueOf(rs.getString(FieldsConstants.TIME_D));
				Post post=new Post();
				post.setMessage(rs.getString(FieldsConstants.MESSAGE_D));
				post.setDate(new Date(time));
				post.setCollegeName(rs.getString(FieldsConstants.COLLEGE_NAME));
				postDtls.add(post);
			}
			ps.close();
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return postDtls;
	}

}
