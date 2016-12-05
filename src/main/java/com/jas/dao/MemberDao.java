package com.jas.dao;

import java.util.List;

import com.jas.model.TMember;
import com.jas.model.TMemberExample;

public interface MemberDao {

	String BEAN_NAME = "MemberDao";
	
	List<TMember> findAll(TMemberExample example);
	String selectMaxMemeberId();
	int insertSelective(TMember model);
	int updateByPrimaryKeySelective(TMember model);
	int delByPrimary(String id);
}
