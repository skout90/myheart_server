package com.myheart.iylm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.myheart.iylm.service.UserService;
import com.myheart.iylm.vo.UserSnsVo;
import com.myheart.iylm.vo.UserVo;

/**
 * <pre>
 * Class Name  : UserController.java
 * Description :
 * Modification Information
 *
 *    수정일　　　 　　  수정자　　　     수정내용
 *    ────────────   ─────────   ───────────────────────────────
 *    2017. 4. 2.   지선학              최초생성
 * </pre>
 *
 * @author 지선학
 * @since 2017. 4. 2.
 * @version 1.0
 *
 * Copyright (C) 2017 by MYHEART All right reserved.
 */

@Controller
public class UserController {

	@Autowired
	UserService userService;

	/**
	 * 
	 * @Author SeonHakJi
	 * @Comment
	 * @param userVo
	 * @param model
	 * @return
	 * @throws Exception
	 */

	// 사용자 등록, 조회 테스트 페이지
	@RequestMapping(value = "/userManageHome", method = RequestMethod.GET)
	public String userManage(UserVo userVo,UserSnsVo userSnsVo, Model model) throws Exception {

		model.addAttribute("selectUserList", userService.selectUserList(userVo));
		/*System.out.println(userService.selectSnsUserList(userSnsVo).size());*/
		
		for(int i=0; i<userService.selectSnsUserList(userSnsVo).size();i++){
		System.out.println("결과 조회:::"+userService.selectSnsUserList(userSnsVo).get(i).getSnsId());
		System.out.println("결과 조회:::"+userService.selectSnsUserList(userSnsVo).get(i).getUserName());
		
		}
		
		model.addAttribute("selectSnsUserList", userService.selectSnsUserList(userSnsVo));

		return "userService";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String facebookLogin(){
		
		return "facebookLogin";
	}
	
	@RequestMapping(value="/sample", method=RequestMethod.GET)
	public String facebookLoginSample(){
		
		return "facebookLoginSample";
	}
	
	

	




}
