package com.jas.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jas.dao.BuyDao;
import com.jas.mappers.TBuyMapper;
import com.jas.model.TBuy;
import com.jas.model.TBuyExample;

@Repository(BuyDao.BEAN_NAME)
public class BuyDaoImpl implements BuyDao {

	@Autowired
	TBuyMapper mapper;
	
	public String selectMaxBuyId() {
		return mapper.selectMaxBuyId();
	}

	public int insertSelective(TBuy model) {
		return mapper.insertSelective(model);
	}

	public List<TBuy> findAll(TBuyExample example) {
		return mapper.selectByExample(example);
	}

	public int updateByPrimaryKeySelective(TBuy model) {
		return mapper.updateByPrimaryKeySelective(model);
	}

	public int delByPrimary(String id) {
		return mapper.deleteByPrimaryKey(id);
	}

}
