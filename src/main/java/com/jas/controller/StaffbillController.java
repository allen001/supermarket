package com.jas.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jas.model.TStaffbill;
import com.jas.service.StaffbillService;
import com.jas.util.Message;

@RestController
@RequestMapping("staffbill")
public class StaffbillController {

	@Resource(name=StaffbillService.BEAN_NAME)
	StaffbillService service;
	
	@RequestMapping("list.do")
	public Message index(){
		List<TStaffbill> list = service.findAll();
		Message message = new Message();
		message.setSuccess(true);
		message.setOthers(list);
		return message;
	}
	
	@RequestMapping("selectMaxStaffbillId.do")
	public Message selectMaxStaffbillId(){
		Message message = new Message();
		message.setSuccess(true);
		message.setOthers(service.selectMaxStaffbillId());
		return message;
	}
	
	@RequestMapping("save.do")
	public Message save(@ModelAttribute TStaffbill model){
		Message message = new Message();
		message.setSuccess(true);
		if(service.insertSelective(model)<=0){
			message.setSuccess(false);
		}
		message.setOthers(model);
		return message;
	}
	
	@RequestMapping("update.do")
	public Message update(@ModelAttribute TStaffbill model){
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
