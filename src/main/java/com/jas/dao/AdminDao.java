package com.jas.dao;

import java.util.List;

import com.jas.model.TAdmin;
import com.jas.model.TAdminExample;

public interface AdminDao {

	String BEAN_NAME = "AdminDao";
	
	List<TAdmin> findAll();
	
	List<TAdmin> selectByExample(TAdminExample example);
	
	int insertSelective(TAdmin model);
	int updateByPrimaryKeySelective(TAdmin model);
	int delByLoginId(String loginId);
}
