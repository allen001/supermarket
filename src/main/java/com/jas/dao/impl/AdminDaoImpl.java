package com.jas.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jas.dao.AdminDao;
import com.jas.mappers.TAdminMapper;
import com.jas.model.TAdmin;
import com.jas.model.TAdminExample;

@Repository(AdminDao.BEAN_NAME)
public class AdminDaoImpl implements AdminDao {

	@Autowired
	public TAdminMapper mapper;
	
	public List<TAdmin> findAll() {
		TAdminExample example = new TAdminExample();
		return mapper.selectByExample(example);
	}

	public List<TAdmin> selectByExample(TAdminExample example) {
		return mapper.selectByExample(example);
	}

	public int insertSelective(TAdmin model) {
		return mapper.insertSelective(model);
	}

	public int updateByPrimaryKeySelective(TAdmin model) {
		TAdminExample example = new TAdminExample();
		TAdminExample.Criteria criteria = example.createCriteria();
		criteria.andLoginIdEqualTo(model.getLoginId());
		return mapper.updateByExampleSelective(model, example);
	}

	public int delByLoginId(String loginId) {
		TAdminExample example = new TAdminExample();
		TAdminExample.Criteria criteria = example.createCriteria();
		criteria.andLoginIdEqualTo(loginId);
		return mapper.deleteByExample(example);
	}

}
