package com.jas.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.stereotype.Service;

import com.jas.dao.BuyDao;
import com.jas.model.TBuy;
import com.jas.model.TBuyExample;
import com.jas.service.BuyService;
import com.jas.util.StringUtils;

@Service(BuyService.BEAN_NAME)
public class BuyServiceImpl implements BuyService {

	@Resource(name=BuyDao.BEAN_NAME)
	BuyDao dao;
	
	public String selectMaxBuyId() {
		String id = dao.selectMaxBuyId();
		String date = "B"+DateFormatUtils.format(new Date(), "yyyyMMdd");
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

	public int insertSelective(TBuy model) {
		model.setCreateBy("10000");
		model.setCreateTime(new Date());
		return dao.insertSelective(model);
	}

	public List<TBuy> findAll(TBuy model) {
		TBuyExample example = new TBuyExample();
		if(model!=null){
			TBuyExample.Criteria criteria = example.createCriteria();
			if(!StringUtils.isEmpty(model.getBuyId())){
				criteria.andBuyIdEqualTo(model.getBuyId());
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

	public int updateByPrimaryKeySelective(TBuy model) {
		return dao.updateByPrimaryKeySelective(model);
	}

	public int delByPrimary(String id) {
		return dao.delByPrimary(id);
	}
}
