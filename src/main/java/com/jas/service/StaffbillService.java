package com.jas.service;

import java.util.List;

import com.jas.model.TStaffbill;

public interface StaffbillService {

	String BEAN_NAME = "StaffbillService";
	
	List<TStaffbill> findAll();
	
	String selectMaxStaffbillId();
	
	int insertSelective(TStaffbill model);
	
	int updateByPrimaryKeySelective(TStaffbill model);
	
	TStaffbill selectByPrimaryKey(String staffId);
	
	int delByPrimary(String id);
}
