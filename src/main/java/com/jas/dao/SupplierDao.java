package com.jas.dao;

import java.util.List;

import com.jas.model.TSupplier;
import com.jas.model.TSupplierExample;

public interface SupplierDao {

	String BEAN_NAME = "SupplierDao";
	
	List<TSupplier> findAll(TSupplierExample example);
	String selectMaxSuppId();
	int insertSelective(TSupplier model);
	int updateByPrimaryKeySelective(TSupplier model);
	TSupplier selectByPrimaryKey(String suppId);
	int delByPrimary(String id);
}
