package com.myheart.iylm.mapper;

import com.myheart.iylm.common.DataMap;
import com.myheart.iylm.vo.PrescriptionVo;

/**
 * <pre>
 * Class Name  : PrescriptionMapper.java
 * Description : 처방전 매퍼
 * Modification Information
 *
 *    수정일　　　 　　  수정자　　　     수정내용
 *    ────────────   ─────────   ───────────────────────────────
 *    2017. 5. 24.   남준호              최초생성
 * </pre>
 *
 * @author 남준호
 * @since 2017. 5. 24.
 * @version 1.0
 *
 * Copyright (C) 2017 by MyHeart All right reserved.
 */
public interface PrescriptionMapper extends GenericMapper<DataMap, PrescriptionVo> {

    /**
     * @Author 남준호
     * @Comment 처방전 상세 내용을 입력합니다.
     * @param paramVo
     * @throws Exception
     */
    public void insertDetail(PrescriptionVo prescriptionVo) throws Exception;
}
