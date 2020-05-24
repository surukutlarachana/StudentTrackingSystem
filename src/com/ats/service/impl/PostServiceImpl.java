package com.ats.service.impl;

import java.util.List;

import com.ats.dao.impl.PostsDetailImpl;
import com.ats.model.Post;
import com.ats.service.PostService;

public class PostServiceImpl implements PostService {

	@Override
	public List<Post> getDetails(){
		PostsDetailImpl psImpl=new PostsDetailImpl();
		return psImpl.getPosts();
	}

}
