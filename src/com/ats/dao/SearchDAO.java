package com.ats.dao;
import java.util.List;

import com.ats.model.RegistrationModel;
import com.ats.model.SearchModel;

public interface SearchDAO {

	List<RegistrationModel> getDetails(SearchModel model);
}
