package com.jas.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jas.model.TAdmin;
import com.jas.model.TStaffbill;
import com.jas.service.AdminService;
import com.jas.service.StaffbillService;
import com.jas.util.Message;

@RestController
@RequestMapping("jas")
public class IndexController {

	@Resource(name=AdminService.BEAN_NAME)
	AdminService aservice;
	@Resource(name=StaffbillService.BEAN_NAME)
	StaffbillService staffservice;
	
	@RequestMapping("login")
	public Message login(String email,String password){
		Message message = new Message();
		message.setSuccess(true);
		Map<String,String> map = new HashMap<String, String>();
		TAdmin model = new TAdmin();
		model.setLoginId(email);
		List<TAdmin> alist = aservice.selectByExample(model);
		if(alist!=null&&!alist.isEmpty()){
			model = alist.get(0);
			if(password.equals(model.getLoginPassword())){
				map.put("loginId", model.getLoginId());
				map.put("loginName", "系统管理员");
				message.setOthers(map);
			}else{
				message.setSuccess(false);
				message.setMessage("密码不正确，请重新输入");
			}
		}else{
			TStaffbill staff = staffservice.selectByPrimaryKey(email);
			if(staff!=null){
				if(password.equals(staff.getStallPassword())){
					map.put("loginId", staff.getStaffId());
					map.put("loginName", staff.getStallName());
					message.setOthers(map);
				}else{
					message.setSuccess(false);
					message.setMessage("密码不正确，请重新输入");
				}
			}else{
				message.setSuccess(false);
				message.setMessage("用户名不正确，请重新输入");
			}
		}
		return message;
	}
}
