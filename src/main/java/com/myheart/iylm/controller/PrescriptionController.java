package com.myheart.iylm.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myheart.iylm.service.PrescriptionService;
import com.myheart.iylm.vo.PrescriptionVo;

/**
 * <pre>
 * Class Name  : PrescriptionController.java
 * Description : 처방전 컨트롤러
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
@Controller
@RequestMapping(value = "/prescription")
public class PrescriptionController {

    @Autowired
    PrescriptionService prescriptionService;

    /**
     * @Author 남준호
     * @Comment 처방전 내용을 입력합니다.
     * @param prescriptionVo
     * @throws Exception
     */
    @RequestMapping("insert")
    void insertPrescription(@RequestBody @Valid PrescriptionVo prescriptionVo, BindingResult result) throws Exception {
        this.prescriptionService.insert(prescriptionVo);
    }

}
