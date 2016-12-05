package com.jas.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jas.model.TAdmin;
import com.jas.service.AdminService;
import com.jas.util.Message;

@RestController
@RequestMapping("admin")
public class AdminController {

	@Resource(name=AdminService.BEAN_NAME)
	AdminService service;
	
	@RequestMapping("list.do")
	public Message index(){
		List<TAdmin> list = service.findAll();
		Message message = new Message();
		message.setSuccess(true);
		message.setOthers(list);
		return message;
	}
	
	@RequestMapping("save.do")
	public Message save(@ModelAttribute TAdmin model){
		Message message = new Message();
		message.setSuccess(true);
		if(service.insertSelective(model)<=0){
			message.setSuccess(false);
		}
		message.setOthers(model);
		return message;
	}
	
	@RequestMapping("update.do")
	public Message update(@ModelAttribute TAdmin model){
		Message message = new Message();
		message.setSuccess(true);
		if(service.updateByPrimaryKeySelective(model)<=0){
			message.setSuccess(false);
		}
		message.setOthers(model);
		return message;
	}
	
	@RequestMapping("getLoginId.do")
	public Object getLoginId(String loginId){
		TAdmin admin = new TAdmin();
		admin.setLoginId(loginId);
		List<TAdmin> list = service.selectByExample(admin);
		Map<String,Boolean> map =new HashMap<String, Boolean>();
		if(list!=null&&!list.isEmpty()){
			map.put("valid", false);
		}else{
			map.put("valid", true);
		}
		return map;
	}
	
	@RequestMapping("chkPassword.do")
	public Object chkPassword(String loginId,String loginBackPassword){
		TAdmin admin = new TAdmin();
		admin.setLoginId(loginId);
		List<TAdmin> list = service.selectByExample(admin);
		Map<String,Boolean> map =new HashMap<String, Boolean>();
		if(list!=null&&!list.isEmpty()){
			admin = list.get(0);
			if(loginBackPassword.equals(admin.getLoginPassword())){
				map.put("valid", true);
			}else{
				map.put("valid", false);
			}
		}else{
			map.put("valid", true);
		}
		return map;
	}
	
	@RequestMapping("del.do")
	public Message del(String loginId){
		Message message = new Message();
		message.setSuccess(true);
		if(service.delByLoginId(loginId)<=0){
			message.setSuccess(false);
		}
		return message;
	}
}
