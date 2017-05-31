package com.myheart.iylm.vo;

import javax.validation.constraints.NotNull;

/**
 * <pre>
 * Class Name  : PrescriptionVo.java
 * Description :
 * Modification Information
 *
 *    수정일　　　 　　  수정자　　　     수정내용
 *    ────────────   ─────────   ───────────────────────────────
 *    2017. 5. 25.   남준호              최초생성
 * </pre>
 *
 * @author 남준호
 * @since 2017. 5. 25.
 * @version 1.0
 *
 * Copyright (C) 2017 by IYL All right reserved.
 */
@lombok.Getter
@lombok.Setter
public class PrescriptionVo {
    // 처방전 일련번호
    @NotNull
    Integer psNo;
    // 사용자 일련번호
    @NotNull
    Integer userNo;
    // 주 질병 코드
    String mainDiseaseCd;
    // 부 질병 코드
    String subDiseaseCd;
    // 시간 구분
    String timeDivision;
    // 약품 코드
    String drugCd;
    // 복용 횟수
    Integer doseCnt;
    // 복용 일수
    Integer dayCnt;
}
