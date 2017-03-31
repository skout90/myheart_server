package com.myheart.iylm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myheart.iylm.mapper.ScheduleMapper;
import com.myheart.iylm.vo.ScheduleVo;

/**
 * <pre>
 * Class Name  : ScheduleService.java
 * Description : �뒪耳�以� �꽌鍮꾩뒪
 * Modification Information
 *
 *    �닔�젙�씪������ ����  �닔�젙�옄������     �닔�젙�궡�슜
 *    ������������������������   ������������������   ��������������������������������������������������������������
 *    2017. 3. 24.   �궓以��샇              理쒖큹�깮�꽦
 * </pre>
 *
 * @author �궓以��샇
 * @since 2017. 3. 24.
 * @version 1.0
 *
 * Copyright (C) 2017 by MyHeart All right reserved.
 */
@Service("scheduleService")
public class ScheduleService {
	
    @Autowired
    ScheduleMapper scheduleMapper;

    /**
     * @Author �궓以��샇
     * @Comment �뒪耳�以� 由ъ뒪�듃瑜� 由ы꽩�빀�땲�떎.
     * @param scheduleVo
     * @return
     * @throws Exception
     */
    public List<ScheduleVo> selectList(ScheduleVo scheduleVo) throws Exception {
        return this.scheduleMapper.selectList(scheduleVo);
    }
}
