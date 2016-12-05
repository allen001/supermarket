package com.jas.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.stereotype.Service;

import com.jas.dao.SellDao;
import com.jas.model.TSell;
import com.jas.model.TSellExample;
import com.jas.service.SellService;
import com.jas.util.StringUtils;

@Service(SellService.BEAN_NAME)
public class SellServiceImpl implements SellService {

	@Resource(name=SellDao.BEAN_NAME)
	SellDao dao;
	
	public String selectMaxSellId() {
		String id = dao.selectMaxSellId();
		String date = "S"+DateFormatUtils.format(new Date(), "yyyyMMdd");
		if(StringUtils.isEmpty(id)){
			id = "000";
		}else{
			String date1 = id.substring(0, 8);
			if(date.equals(date1)){
				id = id.substring(8);
			}else{
				id = "000";
			}
		}
		if(Long.parseLong(id)<100l){
			return date+StringUtils.joinLeftString(Long.parseLong(id)+1, 3, "0");
		}
		return date+String.valueOf(Long.parseLong(id)+1);
	}

	public int insertSelective(TSell model) {
		model.setCreatBy("10000");
		model.setCreatTime(new Date());
		return dao.insertSelective(model);
	}

	public List<TSell> findAll(TSell model) {
		TSellExample example = new TSellExample();
		if(model!=null){
			TSellExample.Criteria criteria = example.createCriteria();
			if(!StringUtils.isEmpty(model.getSellId())){
				criteria.andSellIdEqualTo(model.getSellId());
			}
			if(!StringUtils.isEmpty(model.getSuppId())){
				criteria.andSuppIdEqualTo(model.getSuppId());
			}
			if(!StringUtils.isEmpty(model.getGoodId())){
				criteria.andGoodIdEqualTo(model.getGoodId());
			}
		}
		return dao.findAll(example);
	}

	public int updateByPrimaryKeySelective(TSell model) {
		return dao.updateByPrimaryKeySelective(model);
	}
	
	public int delByPrimary(String id) {
		return dao.delByPrimary(id);
	}
}
