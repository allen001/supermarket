package com.jas.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jas.dao.SupplierDao;
import com.jas.model.TSupplier;
import com.jas.model.TSupplierExample;
import com.jas.service.SupplierService;
import com.jas.util.StringUtils;

@Service(SupplierService.BEAN_NAME)
public class SupplierServiceImpl implements SupplierService {

	@Resource(name=SupplierDao.BEAN_NAME)
	SupplierDao dao;
	
	public String selectMaxSuppId() {
		String id = dao.selectMaxSuppId();
		if(StringUtils.isEmpty(id)){
			id = "000000";
		}
		if(Long.parseLong(id)<100000l){
			return StringUtils.joinLeftString(Long.parseLong(id)+1, 6, "0");
		}
		return String.valueOf(Long.parseLong(id)+1);
	}

	public int insertSelective(TSupplier model) {
		model.setCreateBy("10000");
		model.setCreateTime(new Date());
		return dao.insertSelective(model);
	}

	public List<TSupplier> findAll() {
		TSupplierExample example = new TSupplierExample();
		return dao.findAll(example);
	}

	public int updateByPrimaryKeySelective(TSupplier model) {
		return dao.updateByPrimaryKeySelective(model);
	}

	public TSupplier selectByPrimaryKey(String suppId) {
		return dao.selectByPrimaryKey(suppId);
	}
	
	public int delByPrimary(String id) {
		return dao.delByPrimary(id);
	}
}
