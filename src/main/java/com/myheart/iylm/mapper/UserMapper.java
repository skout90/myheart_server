package com.myheart.iylm.mapper;

import java.util.HashMap;
import java.util.List;

import com.myheart.iylm.vo.UserSnsVo;
import com.myheart.iylm.vo.UserVo;

/**
 * <pre>
 * Class Name  : UserMapper.java
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
	 * @param userSnsVo
	 */
	public void insertSnsUser(UserSnsVo userSnsVo);
	
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
