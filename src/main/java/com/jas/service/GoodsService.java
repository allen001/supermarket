package com.jas.service;

import java.util.List;

import com.jas.model.TGoods;

public interface GoodsService {

	String BEAN_NAME = "GoodsService";
	
	List<TGoods> findAll(TGoods model);
	
	String selectMaxGoodsId();
	
	int insertSelective(TGoods model);
	
	int updateByPrimaryKeySelective(TGoods model);
	
	TGoods selectByPrimaryKey(String goodId);
	
	int delByPrimary(String id);
}
