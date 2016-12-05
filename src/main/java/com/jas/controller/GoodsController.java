package com.jas.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jas.form.TGoodsForm;
import com.jas.model.TGoods;
import com.jas.model.TSupplier;
import com.jas.service.GoodsService;
import com.jas.service.SupplierService;
import com.jas.util.Message;

@RestController
@RequestMapping("goods")
public class GoodsController {

	@Resource(name=GoodsService.BEAN_NAME)
	GoodsService service;
	@Resource(name=SupplierService.BEAN_NAME)
	SupplierService suppservice;
	
	@RequestMapping("list.do")
	public Message index(@ModelAttribute TGoods model){
		List<TGoods> list = service.findAll(model);
		List<TGoodsForm> formlist = new ArrayList<TGoodsForm>();
		for (TGoods goods : list) {
			TGoodsForm form = new TGoodsForm();
			BeanUtils.copyProperties(goods, form);
			TSupplier supp = suppservice.selectByPrimaryKey(goods.getSuppId());
			if(supp!=null){
				form.setSuppName(supp.getSuppName());
			}
			formlist.add(form);
		}
		Message message = new Message();
		message.setSuccess(true);
		message.setOthers(formlist);
		return message;
	}
	
	@RequestMapping("find.do")
	public Message findTGoods(String merchId){
		Message message = new Message();
		message.setSuccess(true);
		TGoods model = new TGoods();
		model.setMerchId(merchId);
		List<TGoods> list = service.findAll(model);
		if(list!=null){
			message.setOthers(list.get(0));
		}else{
			message.setSuccess(false);
			message.setMessage("查询失败，goodId:"+merchId);
		}
		return message;
	}
	
	@RequestMapping("selectMaxGoodsId.do")
	public Message selectMaxGoodsId(){
		Message message = new Message();
		message.setSuccess(true);
		message.setOthers(service.selectMaxGoodsId());
		return message;
	}
	
	@RequestMapping("save.do")
	public Message save(@ModelAttribute TGoods model){
		Message message = new Message();
		message.setSuccess(true);
		if(service.insertSelective(model)<=0){
			message.setSuccess(false);
		}
		message.setOthers(model);
		return message;
	}
	
	@RequestMapping("update.do")
	public Message update(@ModelAttribute TGoods model){
		Message message = new Message();
		message.setSuccess(true);
		if(service.updateByPrimaryKeySelective(model)<=0){
			message.setSuccess(false);
		}
		message.setOthers(model);
		return message;
	}
	
	@RequestMapping("del.do")
	public Message del(String id){
		Message message = new Message();
		message.setSuccess(true);
		if(service.delByPrimary(id)<=0){
			message.setSuccess(false);
		}
		return message;
	}
}
