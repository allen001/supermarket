package com.jas.service;

import java.util.List;

import com.jas.model.TSell;

public interface SellService {

	String BEAN_NAME = "SellService";
	
	List<TSell> findAll(TSell model);
	
	String selectMaxSellId();
	
	int insertSelective(TSell model);
	
	int updateByPrimaryKeySelective(TSell model);
	
	int delByPrimary(String id);
}
