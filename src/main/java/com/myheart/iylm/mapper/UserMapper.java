package com.myheart.iylm.mapper;

import java.util.HashMap;
import java.util.List;

import com.myheart.iylm.vo.UserVo;

public interface UserMapper {
	
	public void insertUser(UserVo userVo);
	
	public List<UserVo> selectUserList(UserVo userVo) throws Exception;
	
	public List<UserVo> searchUserListById(HashMap<String, Object> userId) throws Exception;

	public int loginUserChkIdPass(HashMap<String, Object> loginInfo);

}
