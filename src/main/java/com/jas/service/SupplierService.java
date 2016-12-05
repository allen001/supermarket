package com.jas.service;

import java.util.List;

import com.jas.model.TSupplier;

public interface SupplierService {

	String BEAN_NAME = "SupplierService";
	
	List<TSupplier> findAll();
	
	String selectMaxSuppId();
	
	int insertSelective(TSupplier model);
	
	int updateByPrimaryKeySelective(TSupplier model);
	
	TSupplier selectByPrimaryKey(String suppId);
	
	int delByPrimary(String id);
}
