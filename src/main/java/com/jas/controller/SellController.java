package com.jas.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jas.form.TSellForm;
import com.jas.model.TGoods;
import com.jas.model.TSell;
import com.jas.model.TSupplier;
import com.jas.service.GoodsService;
import com.jas.service.SellService;
import com.jas.service.SupplierService;
import com.jas.util.Message;

@RestController
@RequestMapping("sell")
public class SellController {

	@Resource(name=SellService.BEAN_NAME)
	SellService service;
	@Resource(name=SupplierService.BEAN_NAME)
	SupplierService suppservice;
	@Resource(name=GoodsService.BEAN_NAME)
	GoodsService gservice;
	
	@RequestMapping("list.do")
	public Message index(@ModelAttribute TSell model){
		List<TSell> list = service.findAll(model);
		List<TSellForm> formlist = new ArrayList<TSellForm>();
		for (TSell buy : list) {
			TSellForm form = new TSellForm();
			BeanUtils.copyProperties(buy, form);
			TSupplier supp = suppservice.selectByPrimaryKey(buy.getSuppId());
			if(supp!=null){
				form.setSuppName(supp.getSuppName());
			}
			
			TGoods good = gservice.selectByPrimaryKey(buy.getGoodId());
			if(good!=null){
				form.setGoodName(good.getMerchName());
			}
			
			formlist.add(form);
		}
		Message message = new Message();
		message.setSuccess(true);
		message.setOthers(formlist);
		return message;
	}
	
	@RequestMapping("selectMaxSellId.do")
	public Message selectMaxSellId(){
		Message message = new Message();
		message.setSuccess(true);
		message.setOthers(service.selectMaxSellId());
		return message;
	}
	
	@RequestMapping("save.do")
	public Message save(@ModelAttribute TSellForm model) throws ParseException{
		Message message = new Message();
		message.setSuccess(true);
		model.setSellTime(new SimpleDateFormat("yyyy-MM-dd").parse(model.getSellTime1()));
		if(service.insertSelective(model)<=0){
			message.setSuccess(false);
		}
		message.setOthers(model);
		return message;
	}
	
	@RequestMapping("update.do")
	public Message update(@ModelAttribute TSellForm model) throws ParseException{
		Message message = new Message();
		message.setSuccess(true);
		model.setSellTime(new SimpleDateFormat("yyyy-MM-dd").parse(model.getSellTime1()));
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
