package com.myheart.iylm.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myheart.iylm.mapper.UserMapper;
import com.myheart.iylm.vo.UserVo;

/**
 * <pre>
 * Class Name  : UserService.java
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

@Service("userService")
public class UserService {

	@Autowired
	UserMapper userMapper;

	/**
	 * 
	 * @Author SeonHakJi
	 * @Comment 사용자 등록
	 * @param userVo
	 */
	public void insertUserService(UserVo userVo) {

		this.userMapper.insertUser(userVo);

	}

	/**
	 * 
	 * @Author SeonHakJi
	 * @Comment 사용자 조회
	 * @param userVo
	 * @return
	 * @throws Exception
	 */
	public List<UserVo> selectUserList(UserVo userVo) throws Exception {

		return this.userMapper.selectUserList(userVo);
	}

	/**
	 * 
	 * @Author SeonHakJi
	 * @Comment ID로 사용자 조회
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public List<UserVo> searchUserListById(HashMap<String, Object> userId) throws Exception {

		return this.userMapper.searchUserListById(userId);
	}
	
	/**
	 * 
	 * @Author SeonHakJi
	 * @Comment ID, PASSWORD로 사용자 조회
	 * @param loginInfo
	 * @return
	 */
	public int loginUserChkIdPass(HashMap<String, Object> loginInfo) {
		
		return this.userMapper.loginUserChkIdPass(loginInfo);
	}

}
