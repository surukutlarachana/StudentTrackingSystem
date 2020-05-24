package com.ats.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ats.model.RegistrationModel;
public interface SearchService {

	List<RegistrationModel> getSearchDetails(HttpServletRequest request);
}
