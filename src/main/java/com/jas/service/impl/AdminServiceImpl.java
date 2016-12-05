package com.jas.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jas.dao.AdminDao;
import com.jas.model.TAdmin;
import com.jas.model.TAdminExample;
import com.jas.service.AdminService;
import com.jas.util.StringUtils;

@Service(AdminService.BEAN_NAME)
public class AdminServiceImpl implements AdminService {

	@Resource(name=AdminDao.BEAN_NAME)
	AdminDao dao;
	
	public List<TAdmin> findAll() {
		return dao.findAll();
	}

	public List<TAdmin> selectByExample(TAdmin model) {
		TAdminExample example = new TAdminExample();
		TAdminExample.Criteria criteria = example.createCriteria();
		if(!StringUtils.isEmpty(model.getLoginId())){
			criteria.andLoginIdEqualTo(model.getLoginId());
		}
		if(!StringUtils.isEmpty(model.getLoginPassword())){
			criteria.andLoginPasswordEqualTo(model.getLoginPassword());
		}
		return dao.selectByExample(example);
	}

	public int insertSelective(TAdmin model) {
		model.setCreateBy("10000");
		model.setCreateTime(new Date());
		return dao.insertSelective(model);
	}

	public int updateByPrimaryKeySelective(TAdmin model) {
		return dao.updateByPrimaryKeySelective(model);
	}

	public int delByLoginId(String loginId) {
		return dao.delByLoginId(loginId);
	}

}
