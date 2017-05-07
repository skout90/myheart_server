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
 *   수정일　　　 　　  수정자　　　     수정내용
 *    ────────────   ─────────   ───────────────────────────────
 *    2017. 4. 2.   지선학              최초생성
 * </pre>
 *
 * @author 지선학
 * @since 2017. 4. 2.
 * @version 1.0
 *
 *          Copyright (C) 2017 by MYHEART All right reserved.
 */

@Service("userService")
public class UserService {

	@Autowired
	UserMapper userMapper;

	/**
	 * 
	 * @Author SeonHakJi
	 * @Comment �궗�슜�옄 �벑濡�
	 * @param userVo
	 */
	public void insertUserService(UserVo userVo) {

		this.userMapper.insertUser(userVo);

	}

	/**
	 * 
	 * @Author SeonHakJi
	 * @Comment �궗�슜�옄 議고쉶
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
	 * @Comment ID濡� �궗�슜�옄 議고쉶
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public List<UserVo> searchUserListById(HashMap<String, Object> userId) throws Exception {

		return this.userMapper.searchUserListById(userId);
	}
	/**
	 * @Author SeonHakJi
	 * @Comment snsId로 사용자 검색
	 * @param snsId
	 * @return
	 * @throws Exception
	 */
	public List<UserVo> searchUserListByFbSnsId(HashMap<String, Object> snsId) throws Exception {

		return this.userMapper.searchUserListByFbSnsId(snsId);
	}

	/**
	 * 
	 * @param email
	 * @return
	 * @throws Exception
	 */
	public List<UserVo> searchUserListByEmail(String email) throws Exception {

		return this.userMapper.searchUserListByEmail(email);

	}

	/**
	 * 
	 * @Author SeonHakJi
	 * @Comment ID, PASSWORD濡� �궗�슜�옄 議고쉶
	 * @param loginInfo
	 * @return
	 */
	public int loginUserChkIdPass(HashMap<String, Object> loginInfo) {

		return this.userMapper.loginUserChkIdPass(loginInfo);
	}
	
	/**
	 * 
	 * @param addUserInfo
	 */
	public void mergeAccount(HashMap<String, String> addUserInfo) {
		this.userMapper.mergeAccount(addUserInfo);
	}

}
