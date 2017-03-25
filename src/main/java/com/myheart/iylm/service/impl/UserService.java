package com.myheart.iylm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myheart.iylm.dto.UserVo;
import com.myheart.iylm.mapper.UserMapper;

@Service("userService")
public class UserService {
	
	@Autowired
	UserMapper userMapper;
	
	public void insertUserService(UserVo userVo){
		
		userMapper.insertUser(userVo);
		
	}
	

}
