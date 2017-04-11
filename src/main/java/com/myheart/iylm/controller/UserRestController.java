package com.myheart.iylm.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.util.BeanUtil;
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
 *          Copyright (C) 2017 by MYHEART All right reserved.
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
	public List<UserVo> selectUserList(UserVo userVo) throws Exception {

		// model.addAttribute("selectUserList",
		// userService.selectUserList(userVo));

		return userService.selectUserList(userVo);
	}

	@RequestMapping(value = "selectSnsUserList", method = RequestMethod.GET)
	public List<UserSnsVo> selectSnsUserList(UserSnsVo userSnsVo) throws Exception {

		// model.addAttribute("selectSnsUserList",
		// userService.selectUserSnsList(userSnsVo));

		return userService.selectSnsUserList(userSnsVo);
	}
	
	@RequestMapping(value = "socialInsertUser", method = RequestMethod.POST)
	public void socialLoginService(UserSnsVo userSnsVo) throws Exception {
		// 계정 통합버튼 입력 받지 못한 추가 사용자 정보 update
		
		if(userService.searchSnsUserListBySnsId(userSnsVo.getSnsId()).size()<1){
			userService.insertUserSnsService(userSnsVo);
			
			//user 테이블에 sns 사용자 정보 저장
			UserVo userVo = new UserVo();
			userVo.setSnsId(userSnsVo.getSnsId());
			userVo.setSnsType(userSnsVo.getSnsType());
			userVo.setUserName(userSnsVo.getUserName());
			userVo.setEmail(userSnsVo.getEmail());
			
			userService.insertUserService(userVo);
		}else{
			System.out.println("이미 등록된 계정 존재.");
		}

	}

	@RequestMapping(value = "searchUserListById", method = RequestMethod.POST)
	public List<UserVo> searchUserListById(@RequestParam("userId") String userId, HashMap<String, Object> userIdMap)
			throws Exception {
		System.out.println("searchUserListById()");
		System.out.println(userId);
		userIdMap.put("userId", userId);

		List<UserVo> result = userService.searchUserListById(userIdMap);
		System.out.println(result);
		return result;

	}
	
	@RequestMapping(value="mergeAccount", method=RequestMethod.POST)
	public void mergeAccount(HashMap<String,String> addUserInfo) throws Exception{
	System.out.println("snsId:::"+addUserInfo.get("snsId"));
		userService.mergeAccount(addUserInfo);
		
	}

	@RequestMapping(value = "loginService", method = RequestMethod.POST)
	public boolean loginService(@RequestParam("loginUserId") String loginUserId,
			@RequestParam("loginPassword") String loginPassword) throws Exception {

		HashMap<String, Object> loginInfoMap = new HashMap<String, Object>();
		loginInfoMap.put("userId", loginUserId);
		loginInfoMap.put("password", loginPassword);

		if (userService.loginUserChkIdPass(loginInfoMap) > 0) {
			return true;
		} else {
			return false;
		}

	}

	@RequestMapping(value = "facebook_login_check", method = RequestMethod.POST)
	public void socialLoginService(@RequestParam("uid") String uid, @RequestParam("accessToken") String accessToken) {
		System.out.println("uid : " + uid);
		System.out.println("accessToken : " + accessToken);

	}

}
