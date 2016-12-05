package com.jas.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jas.dao.GoodsDao;
import com.jas.mappers.TGoodsMapper;
import com.jas.model.TGoods;
import com.jas.model.TGoodsExample;

@Repository(GoodsDao.BEAN_NAME)
public class GoodsDaoImpl implements GoodsDao {

	@Autowired
	TGoodsMapper mapper;
	
	public String selectMaxGoodsId() {
		return mapper.selectMaxGoodsId();
	}

	public int insertSelective(TGoods model) {
		return mapper.insertSelective(model);
	}

	public List<TGoods> findAll(TGoodsExample example) {
		return mapper.selectByExample(example);
	}

	public int updateByPrimaryKeySelective(TGoods model) {
		return mapper.updateByPrimaryKeySelective(model);
	}

	public TGoods selectByPrimaryKey(String goodId) {
		return mapper.selectByPrimaryKey(goodId);
	}

	public int delByPrimary(String id) {
		return mapper.deleteByPrimaryKey(id);
	}

}
