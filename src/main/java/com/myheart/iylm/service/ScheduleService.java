package com.myheart.iylm.service;

import org.springframework.stereotype.Service;

import com.myheart.iylm.common.DataMap;
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
public class ScheduleService extends GenericService<ScheduleMapper, DataMap, ScheduleVo> {
}
