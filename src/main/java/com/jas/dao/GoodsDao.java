package com.jas.dao;

import java.util.List;

import com.jas.model.TGoods;
import com.jas.model.TGoodsExample;

public interface GoodsDao {

	String BEAN_NAME = "GoodsDao";
	
	List<TGoods> findAll(TGoodsExample example);
	String selectMaxGoodsId();
	int insertSelective(TGoods model);
	int updateByPrimaryKeySelective(TGoods model);
	TGoods selectByPrimaryKey(String goodId);
	int delByPrimary(String id);
}
