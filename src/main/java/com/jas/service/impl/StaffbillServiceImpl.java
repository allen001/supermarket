package com.jas.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jas.dao.StaffbillDao;
import com.jas.model.TStaffbill;
import com.jas.model.TStaffbillExample;
import com.jas.service.StaffbillService;
import com.jas.util.StringUtils;

@Service(StaffbillService.BEAN_NAME)
public class StaffbillServiceImpl implements StaffbillService {

	@Resource(name=StaffbillDao.BEAN_NAME)
	StaffbillDao dao;
	
	public String selectMaxStaffbillId() {
		String id = dao.selectMaxStaffbillId();
		if(StringUtils.isEmpty(id)){
			id = "000000";
		}
		if(Long.parseLong(id)<100000l){
			return StringUtils.joinLeftString(Long.parseLong(id)+1, 6, "0");
		}
		return String.valueOf(Long.parseLong(id)+1);
	}

	public int insertSelective(TStaffbill model) {
		model.setCreateBy("10000");
		model.setCreateTime(new Date());
		return dao.insertSelective(model);
	}

	public List<TStaffbill> findAll() {
		TStaffbillExample example = new TStaffbillExample();
		return dao.findAll(example);
	}

	public int updateByPrimaryKeySelective(TStaffbill model) {
		return dao.updateByPrimaryKeySelective(model);
	}

	public TStaffbill selectByPrimaryKey(String staffId) {
		return dao.selectByPrimaryKey(staffId);
	}
	
	public int delByPrimary(String id) {
		return dao.delByPrimary(id);
	}
}
