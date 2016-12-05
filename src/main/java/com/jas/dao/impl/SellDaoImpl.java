package com.jas.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jas.dao.SellDao;
import com.jas.mappers.TSellMapper;
import com.jas.model.TSell;
import com.jas.model.TSellExample;

@Repository(SellDao.BEAN_NAME)
public class SellDaoImpl implements SellDao{

	@Autowired
	TSellMapper mapper;
	
	public String selectMaxSellId() {
		return mapper.selectMaxSellId();
	}

	public int insertSelective(TSell model) {
		return mapper.insertSelective(model);
	}

	public List<TSell> findAll(TSellExample example) {
		return mapper.selectByExample(example);
	}

	public int updateByPrimaryKeySelective(TSell model) {
		return mapper.updateByPrimaryKeySelective(model);
	}

	public int delByPrimary(String id) {
		return mapper.deleteByPrimaryKey(id);
	}

}
