package com.myheart.iylm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myheart.iylm.dto.UserVo;
import com.myheart.iylm.service.impl.UserService;

/**
 * <pre>
 * Class Name  : UserController.java
 * Description :
 * Modification Information
 *
 *    수정일　　　 　　  수정자　　　     수정내용
 *    ────────────   ─────────   ───────────────────────────────
 *    2017. 3. 26.   지선학              최초생성
 * </pre>
 *
 * @author 지선학
 * @since 2017. 3. 26.
 * @version 1.0
 *
 * Copyright (C) 2017 by MYHEART All right reserved.
 */

@RequestMapping(value="/user")
@Controller
public class UserController {
	
	 @Autowired
	 UserService userService;
	

	/**
	 * @Author apple
	 * @Comment
	 * @param userVo
	 * @param model
	 * @return
	 */
	@RequestMapping("insertUser")

	public String insertUser(@RequestParam UserVo userVo,Model model){
		
		userService.insertUserService(userVo);

		return "userService";
	}
	

}