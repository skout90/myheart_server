package com.myheart.iylm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myheart.iylm.service.ScheduleService;
import com.myheart.iylm.vo.ScheduleVo;

/**
 * <pre>
 * Class Name  : ScheduleController.java
 * Description : 스케줄 컨트롤러
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
@RequestMapping(value = "/schedule")
@RestController
public class ScheduleController {

    @Autowired
    ScheduleService scheduleService;

    /**
     * @Author 남준호
     * @Comment 스케줄 리스트를 리턴합니다.
     * @param scheduleVo
     * @return
     */
    @RequestMapping(value = "selectScheduleList")
    public List<ScheduleVo> selectScheduleList(ScheduleVo scheduleVo) throws Exception {
        return this.scheduleService.selectList(scheduleVo);
    }
}
