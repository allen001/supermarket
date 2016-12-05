package com.jas.service;

import java.util.List;

import com.jas.model.TAdmin;

public interface AdminService {

	String BEAN_NAME = "AdminService";
	
	List<TAdmin> findAll();
	
	List<TAdmin> selectByExample(TAdmin model);
	
	int insertSelective(TAdmin model);
	
	int updateByPrimaryKeySelective(TAdmin model);
	
	int delByLoginId(String loginId);
}
