package com.jas.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jas.model.TMember;
import com.jas.service.MemberService;
import com.jas.util.Message;

@RestController
@RequestMapping("member")
public class MemberController {

	@Resource(name=MemberService.BEAN_NAME)
	MemberService service;
	
	@RequestMapping("list.do")
	public Message index(){
		List<TMember> list = service.findAll();
		Message message = new Message();
		message.setSuccess(true);
		message.setOthers(list);
		return message;
	}
	
	@RequestMapping("selectMaxMemberId.do")
	public Message selectMaxStaffbillId(){
		Message message = new Message();
		message.setSuccess(true);
		message.setOthers(service.selectMaxMemberId());
		return message;
	}
	
	@RequestMapping("save.do")
	public Message save(@ModelAttribute TMember model){
		Message message = new Message();
		message.setSuccess(true);
		if(service.insertSelective(model)<=0){
			message.setSuccess(false);
		}
		message.setOthers(model);
		return message;
	}
	
	@RequestMapping("update.do")
	public Message update(@ModelAttribute TMember model){
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
