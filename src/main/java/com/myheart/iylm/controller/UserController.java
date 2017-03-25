package com.myheart.iylm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myheart.iylm.dto.UserVo;
import com.myheart.iylm.service.impl.UserService;

@Controller
public class UserController {
	
	 @Autowired
	 UserService userService;
	
	@RequestMapping("/insertUser")
	public String insertUser(@RequestParam UserVo userVo,Model model){
		
		userService.insertUserService(userVo);
		
		return "userService";
	}
	

}
