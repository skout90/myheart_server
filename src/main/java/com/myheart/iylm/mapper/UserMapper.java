package com.myheart.iylm.mapper;

import java.util.HashMap;
import java.util.List;

import com.myheart.iylm.vo.UserVo;

/**
 * <pre>
 * Class Name  : UserMapper.java
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

public interface UserMapper {
	
	/**
	 * 
	 * @Author SeonHakJi
	 * @Comment
	 * @param userVo
	 */
	public void insertUser(UserVo userVo);
	
	/**
	 * 
	 * @Author SeonHakJi
	 * @Comment
	 * @param userVo
	 * @return
	 * @throws Exception
	 */
	public List<UserVo> selectUserList(UserVo userVo) throws Exception;
	
	/**
	 * 
	 * @Author SeonHakJi
	 * @Comment
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public List<UserVo> searchUserListById(HashMap<String, Object> userId) throws Exception;

	/**
	 * 
	 * @Author SeonHakJi
	 * @Comment
	 * @param loginInfo
	 * @return
	 */
	public int loginUserChkIdPass(HashMap<String, Object> loginInfo);

}
