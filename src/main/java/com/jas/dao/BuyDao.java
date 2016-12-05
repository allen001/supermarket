package com.jas.dao;

import java.util.List;

import com.jas.model.TBuy;
import com.jas.model.TBuyExample;

public interface BuyDao {

	String BEAN_NAME = "BuyDao";
	
	List<TBuy> findAll(TBuyExample example);
	String selectMaxBuyId();
	int insertSelective(TBuy model);
	int updateByPrimaryKeySelective(TBuy model);
	int delByPrimary(String id);
}
