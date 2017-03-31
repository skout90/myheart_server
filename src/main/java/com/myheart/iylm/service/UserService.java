package com.myheart.iylm.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myheart.iylm.mapper.UserMapper;
import com.myheart.iylm.vo.UserVo;

@Service("userService")
public class UserService {

	@Autowired
	UserMapper userMapper;

	public void insertUserService(UserVo userVo) {

		this.userMapper.insertUser(userVo);

	}

	public List<UserVo> selectUserList(UserVo userVo) throws Exception {

		return this.userMapper.selectUserList(userVo);
	}

	public List<UserVo> searchUserListById(HashMap<String, Object> userId) throws Exception {

		return this.userMapper.searchUserListById(userId);
	}
	
	public int loginUserChkIdPass(HashMap<String, Object> loginInfo) {
		
		return this.userMapper.loginUserChkIdPass(loginInfo);
	}

}
