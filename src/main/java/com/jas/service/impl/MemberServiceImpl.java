package com.jas.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jas.dao.MemberDao;
import com.jas.model.TMember;
import com.jas.model.TMemberExample;
import com.jas.service.MemberService;
import com.jas.util.StringUtils;

@Service(MemberService.BEAN_NAME)
public class MemberServiceImpl implements MemberService {

	@Resource(name=MemberDao.BEAN_NAME)
	MemberDao dao;
	
	public String selectMaxMemberId() {
		String id = dao.selectMaxMemeberId();
		if(StringUtils.isEmpty(id)){
			id = "000000";
		}
		if(Long.parseLong(id)<100000l){
			return StringUtils.joinLeftString(Long.parseLong(id)+1, 6, "0");
		}
		return String.valueOf(Long.parseLong(id)+1);
	}

	public int insertSelective(TMember model) {
		model.setCreateBy("10000");
		model.setCreateTime(new Date());
		return dao.insertSelective(model);
	}

	public List<TMember> findAll() {
		TMemberExample example = new TMemberExample();
		return dao.findAll(example);
	}

	public int updateByPrimaryKeySelective(TMember model) {
		return dao.updateByPrimaryKeySelective(model);
	}
	
	public int delByPrimary(String id) {
		return dao.delByPrimary(id);
	}
}
