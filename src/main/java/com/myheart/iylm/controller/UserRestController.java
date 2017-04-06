package com.myheart.iylm.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myheart.iylm.service.UserService;
import com.myheart.iylm.vo.UserSnsVo;
import com.myheart.iylm.vo.UserVo;

/**
 * <pre>
 * Class Name  : UserRestController.java
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

@RestController
@RequestMapping(value = "/user")
public class UserRestController {

	@Autowired
	UserService userService;

	/**
	 * @Author ������
	 * @Comment
	 * @param userVo
	 * @param model
	 * @return
	 */

	@RequestMapping(value = "insertUser", method = RequestMethod.POST)
	public void insertUser(UserVo userVo) {

		Date date = new Date();
		userVo.setReqDt(date);

		userService.insertUserService(userVo);
	}

	@RequestMapping(value = "selectUserList", method = RequestMethod.GET)
	public List<UserVo> selectUserList(UserVo userVo, Model model) throws Exception {

		model.addAttribute("selectUserList", userService.selectUserList(userVo));

		return userService.selectUserList(userVo);
	}

	@RequestMapping(value = "searchUserListById", method = RequestMethod.POST)
	public List<UserVo> searchUserListById(@RequestParam("userId") String userId, HashMap<String, Object> userIdMap) throws Exception {
		System.out.println("searchUserListById()");
		System.out.println(userId);
		userIdMap.put("userId", userId);

		List<UserVo> result = userService.searchUserListById(userIdMap);
		System.out.println(result);
		return result;

	}

	@RequestMapping(value = "loginService", method = RequestMethod.POST)
	public boolean loginService(@RequestParam("loginUserId") String loginUserId, @RequestParam("loginPassword") String loginPassword) throws Exception {

		HashMap<String, Object> loginInfoMap = new HashMap<String, Object>();
		loginInfoMap.put("userId", loginUserId);
		loginInfoMap.put("password", loginPassword);

		if ( userService.loginUserChkIdPass(loginInfoMap) > 0 ) {
			return true;
		} else {
			return false;
		}

	}
	
	@RequestMapping(value="socialInsertUser", method= RequestMethod.POST)
	public void socialLoginService(UserSnsVo userSnsVo, HttpServletResponse response){
		//처음 sns를 통해서 사용자가 가입을 시도하면  Sns테이블과 User테이블에 
		//응답받은 사용자 정보를 2개의 테이블에 저장 시킴
		//User 테이블에 저장하지 못한 정보는 Sns에서 응답받은 정보로 처리 
		//userid <- snsId , 연락처 <-없음
		//기존 User 테이블에 SNS에서 전달받은 이메일 계정이 있으면 로그인
		
		
		
		Date date = new Date();
		userSnsVo.setReqDt(date);
		
		userService.insertUserSnsService(userSnsVo);
		
	}
	

}
