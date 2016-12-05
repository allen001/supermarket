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

import com.jas.form.TBuyForm;
import com.jas.model.TBuy;
import com.jas.model.TGoods;
import com.jas.model.TSupplier;
import com.jas.service.BuyService;
import com.jas.service.GoodsService;
import com.jas.service.SupplierService;
import com.jas.util.Message;

@RestController
@RequestMapping("buy")
public class BuyController {

	@Resource(name=BuyService.BEAN_NAME)
	BuyService service;
	@Resource(name=SupplierService.BEAN_NAME)
	SupplierService suppservice;
	@Resource(name=GoodsService.BEAN_NAME)
	GoodsService gservice;
	
	@RequestMapping("list.do")
	public Message index(@ModelAttribute TBuy model){
		List<TBuy> list = service.findAll(model);
		List<TBuyForm> formlist = new ArrayList<TBuyForm>();
		for (TBuy buy : list) {
			TBuyForm form = new TBuyForm();
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
	
	@RequestMapping("selectMaxBuyId.do")
	public Message selectMaxBuyId(){
		Message message = new Message();
		message.setSuccess(true);
		message.setOthers(service.selectMaxBuyId());
		return message;
	}
	
	@RequestMapping("save.do")
	public Message save(@ModelAttribute TBuyForm model) throws ParseException{
		Message message = new Message();
		message.setSuccess(true);
		model.setBuyTime(new SimpleDateFormat("yyyy-MM-dd").parse(model.getBuyTime1()));
		if(service.insertSelective(model)<=0){
			message.setSuccess(false);
		}
		message.setOthers(model);
		return message;
	}
	
	@RequestMapping("update.do")
	public Message update(@ModelAttribute TBuyForm model) throws ParseException{
		Message message = new Message();
		message.setSuccess(true);
		model.setBuyTime(new SimpleDateFormat("yyyy-MM-dd").parse(model.getBuyTime1()));
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
