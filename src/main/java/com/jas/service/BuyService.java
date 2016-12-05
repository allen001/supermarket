package com.jas.service;

import java.util.List;

import com.jas.model.TBuy;

public interface BuyService {

	String BEAN_NAME = "BuyService";
	
	List<TBuy> findAll(TBuy model);
	
	String selectMaxBuyId();
	
	int insertSelective(TBuy model);
	
	int updateByPrimaryKeySelective(TBuy model);
	
	int delByPrimary(String id);
}
