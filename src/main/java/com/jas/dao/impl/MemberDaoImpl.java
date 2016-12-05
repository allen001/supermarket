package com.jas.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jas.dao.MemberDao;
import com.jas.mappers.TMemberMapper;
import com.jas.model.TMember;
import com.jas.model.TMemberExample;

@Repository(MemberDao.BEAN_NAME)
public class MemberDaoImpl implements MemberDao {

	@Autowired
	TMemberMapper mapper;
	
	public String selectMaxMemeberId() {
		return mapper.selectMaxMemberId();
	}

	public int insertSelective(TMember model) {
		return mapper.insertSelective(model);
	}

	public List<TMember> findAll(TMemberExample example) {
		return mapper.selectByExample(example);
	}

	public int updateByPrimaryKeySelective(TMember model) {
		return mapper.updateByPrimaryKeySelective(model);
	}

	public int delByPrimary(String id) {
		return mapper.deleteByPrimaryKey(id);
	}

}
