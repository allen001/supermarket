package com.jas.dao;

import java.util.List;

import com.jas.model.TSell;
import com.jas.model.TSellExample;

public interface SellDao {

	String BEAN_NAME = "SellDao";
	
	List<TSell> findAll(TSellExample example);
	String selectMaxSellId();
	int insertSelective(TSell model);
	int updateByPrimaryKeySelective(TSell model);
	int delByPrimary(String id);
}
