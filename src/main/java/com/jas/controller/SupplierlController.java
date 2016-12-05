package com.jas.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jas.model.TSupplier;
import com.jas.service.SupplierService;
import com.jas.util.Message;

@RestController
@RequestMapping("supplier")
public class SupplierlController {

	@Resource(name=SupplierService.BEAN_NAME)
	SupplierService service;
	
	@RequestMapping("list.do")
	public Message index(){
		List<TSupplier> list = service.findAll();
		Message message = new Message();
		message.setSuccess(true);
		message.setOthers(list);
		return message;
	}
	
	@RequestMapping("selectMaxSuppId.do")
	public Message selectMaxStaffbillId(){
		Message message = new Message();
		message.setSuccess(true);
		message.setOthers(service.selectMaxSuppId());
		return message;
	}
	
	@RequestMapping("save.do")
	public Message save(@ModelAttribute TSupplier model){
		Message message = new Message();
		message.setSuccess(true);
		if(service.insertSelective(model)<=0){
			message.setSuccess(false);
		}
		message.setOthers(model);
		return message;
	}
	
	@RequestMapping("update.do")
	public Message update(@ModelAttribute TSupplier model){
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
