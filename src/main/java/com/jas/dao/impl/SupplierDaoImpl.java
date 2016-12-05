package com.jas.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jas.dao.SupplierDao;
import com.jas.mappers.TSupplierMapper;
import com.jas.model.TSupplier;
import com.jas.model.TSupplierExample;

@Repository(SupplierDao.BEAN_NAME)
public class SupplierDaoImpl implements SupplierDao {

	@Autowired
	TSupplierMapper mapper;
	
	public String selectMaxSuppId() {
		return mapper.selectMaxSuppId();
	}

	public int insertSelective(TSupplier model) {
		return mapper.insertSelective(model);
	}

	public List<TSupplier> findAll(TSupplierExample example) {
		return mapper.selectByExample(example);
	}

	public int updateByPrimaryKeySelective(TSupplier model) {
		return mapper.updateByPrimaryKeySelective(model);
	}

	public TSupplier selectByPrimaryKey(String suppId) {
		return mapper.selectByPrimaryKey(suppId);
	}

	public int delByPrimary(String id) {
		return mapper.deleteByPrimaryKey(id);
	}

}
