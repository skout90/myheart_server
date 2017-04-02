package com.myheart.iylm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myheart.iylm.service.UserService;
import com.myheart.iylm.vo.UserVo;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	// 사용자 등록, 조회 테스트 페이지
	@RequestMapping(value = "/userManageHome", method = RequestMethod.GET)
	public String userManage(UserVo userVo, Model model) throws Exception {

		model.addAttribute("selectUserList", userService.selectUserList(userVo));

		return "userService";
	}

}
