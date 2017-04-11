package com.myheart.iylm.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myheart.iylm.mapper.UserMapper;
import com.myheart.iylm.vo.UserSnsVo;
import com.myheart.iylm.vo.UserVo;

/**
 * <pre>
 * Class Name  : UserService.java
 * Description :
 * Modification Information
 *
 *    �닔�젙�씪������ ����  �닔�젙�옄������     �닔�젙�궡�슜
 *    ������������������������   ������������������   ��������������������������������������������������������������
 *    2017. 4. 2.   吏��꽑�븰              理쒖큹�깮�꽦
 * </pre>
 *
 * @author 吏��꽑�븰
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
	 * @param userSnsVo
	 */
	public void insertUserSnsService(UserSnsVo userSnsVo) {
		
		this.userMapper.insertSnsUser(userSnsVo);
		
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
	 * @param snsId
	 * @return
	 * @throws Exception
	 */
	public List<UserSnsVo> searchSnsUserListBySnsId(String snsId) throws Exception {

		return this.userMapper.searchSnsUserListById(snsId);
		
	}
	/**
	 * 
	 * @param email
	 * @return
	 * @throws Exception
	 */
	public List<UserSnsVo> searchSnsUserListByEmail(String email) throws Exception {
		return this.userMapper.searchSnsUserListByEmail(email);
	}

	/**
	 * 
	 * @param userSnsVo
	 * @return
	 * @throws Exception
	 */
	public List<UserSnsVo> selectSnsUserList(UserSnsVo userSnsVo) throws Exception {

		return this.userMapper.selectSnsUserList(userSnsVo);
		
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
	
	public void mergeAccount(HashMap<String, String> addUserInfo){
		this.userMapper.mergeAccount(addUserInfo);
	}

}
