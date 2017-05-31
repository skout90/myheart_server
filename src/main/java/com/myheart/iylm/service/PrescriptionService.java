package com.myheart.iylm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myheart.iylm.common.DataMap;
import com.myheart.iylm.mapper.PrescriptionMapper;
import com.myheart.iylm.vo.PrescriptionVo;

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
public class PrescriptionService extends GenericService<PrescriptionMapper, DataMap, PrescriptionVo> {

    @Autowired
    PrescriptionMapper mapper;

    /**
     * @Author 남준호
     * @Comment 처방전을 입력합니다.
     * @param paramVo
     * @throws Exception
     */
    @Override
    public void insert(PrescriptionVo prescriptionVo) throws Exception {
        super.insert(prescriptionVo);

        // 세부 약물 내용 입력
        this.insertDetail(prescriptionVo);

        // 스케줄 기본 값 등록

    }

    /**
     * @Author 남준호
     * @Comment 처방전 상세 내용을 입력합니다.
     * @param paramVo
     * @throws Exception
     */
    public void insertDetail(PrescriptionVo prescriptionVo) throws Exception {
        this.mapper.insertDetail(prescriptionVo);
    }
}
