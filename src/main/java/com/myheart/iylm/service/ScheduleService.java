package com.myheart.iylm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myheart.iylm.mapper.ScheduleMapper;
import com.myheart.iylm.vo.ScheduleVo;

/**
 * <pre>
 * Class Name  : ScheduleService.java
 * Description : 스케줄 서비스
 * Modification Information
 *
 *    수정일　　　 　　  수정자　　　     수정내용
 *    ────────────   ─────────   ───────────────────────────────
 *    2017. 3. 24.   남준호              최초생성
 * </pre>
 *
 * @author 남준호
 * @since 2017. 3. 24.
 * @version 1.0
 *
 * Copyright (C) 2017 by MyHeart All right reserved.
 */
@Service
public class ScheduleService {
    @Autowired
    ScheduleMapper scheduleMapper;

    /**
     * @Author 남준호
     * @Comment 스케줄 리스트를 리턴합니다.
     * @param scheduleVo
     * @return
     * @throws Exception
     */
    public List<ScheduleVo> selectList(ScheduleVo scheduleVo) throws Exception {
        return this.scheduleMapper.selectList(scheduleVo);
    }
}