package com.jas.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jas.dao.GoodsDao;
import com.jas.model.TGoods;
import com.jas.model.TGoodsExample;
import com.jas.service.GoodsService;
import com.jas.util.StringUtils;

@Service(GoodsService.BEAN_NAME)
public class GoodsServiceImpl implements GoodsService {

	@Resource(name=GoodsDao.BEAN_NAME)
	GoodsDao dao;
	
	public String selectMaxGoodsId() {
		String id = dao.selectMaxGoodsId();
		if(StringUtils.isEmpty(id)){
			id = "000000";
		}
		if(Long.parseLong(id)<100000l){
			return StringUtils.joinLeftString(Long.parseLong(id)+1, 6, "0");
		}
		return String.valueOf(Long.parseLong(id)+1);
	}

	public int insertSelective(TGoods model) {
		model.setCreateBy("10000");
		model.setCreateTime(new Date());
		return dao.insertSelective(model);
	}

	public List<TGoods> findAll(TGoods model) {
		TGoodsExample example = new TGoodsExample();
		if(model!=null){
			TGoodsExample.Criteria criteria = example.createCriteria();
			if(!StringUtils.isEmpty(model.getMerchId())){
				criteria.andMerchIdEqualTo(model.getMerchId());
			}
			if(!StringUtils.isEmpty(model.getSuppId())){
				criteria.andSuppIdEqualTo(model.getSuppId());
			}
		}
		return dao.findAll(example);
	}

	public int updateByPrimaryKeySelective(TGoods model) {
		return dao.updateByPrimaryKeySelective(model);
	}

	public TGoods selectByPrimaryKey(String goodId) {
		return dao.selectByPrimaryKey(goodId);
	}
	
	public int delByPrimary(String id) {
		return dao.delByPrimary(id);
	}
}
