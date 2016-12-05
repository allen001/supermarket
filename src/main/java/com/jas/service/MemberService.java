package com.jas.service;

import java.util.List;

import com.jas.model.TMember;

public interface MemberService {

	String BEAN_NAME = "MemberService";
	
	List<TMember> findAll();
	
	String selectMaxMemberId();
	
	int insertSelective(TMember model);
	
	int updateByPrimaryKeySelective(TMember model);
	
	int delByPrimary(String id);
}
