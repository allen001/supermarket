package com.jas.dao;

import java.util.List;

import com.jas.model.TStaffbill;
import com.jas.model.TStaffbillExample;

public interface StaffbillDao {

	String BEAN_NAME = "StaffbillDao";
	
	List<TStaffbill> findAll(TStaffbillExample example);
	String selectMaxStaffbillId();
	int insertSelective(TStaffbill model);
	int updateByPrimaryKeySelective(TStaffbill model);
	TStaffbill selectByPrimaryKey(String staffId);
	int delByPrimary(String id);
}
