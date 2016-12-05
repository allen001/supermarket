package com.jas.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jas.dao.StaffbillDao;
import com.jas.mappers.TStaffbillMapper;
import com.jas.model.TStaffbill;
import com.jas.model.TStaffbillExample;

@Repository(StaffbillDao.BEAN_NAME)
public class StaffbillDaoImpl implements StaffbillDao {

	@Autowired
	TStaffbillMapper mapper;
	
	public String selectMaxStaffbillId() {
		return mapper.selectMaxStaffbillId();
	}

	public int insertSelective(TStaffbill model) {
		return mapper.insertSelective(model);
	}

	public List<TStaffbill> findAll(TStaffbillExample example) {
		return mapper.selectByExample(example);
	}

	public int updateByPrimaryKeySelective(TStaffbill model) {
		return mapper.updateByPrimaryKeySelective(model);
	}

	public TStaffbill selectByPrimaryKey(String staffId) {
		return mapper.selectByPrimaryKey(staffId);
	}

	public int delByPrimary(String id) {
		return mapper.deleteByPrimaryKey(id);
	}

}
