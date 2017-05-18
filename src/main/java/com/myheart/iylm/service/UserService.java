package com.myheart.iylm.service;

import org.springframework.stereotype.Service;

import com.myheart.iylm.common.DataMap;
import com.myheart.iylm.mapper.UserMapper;
import com.myheart.iylm.vo.UserVo;

@Service
public class UserService extends GenericService<UserMapper, DataMap, UserVo> {

}
