package com.myheart.iylm.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myheart.iylm.dto.DrugDto;
import com.myheart.iylm.mapper.DrugMapper;

@Service("drugService")
public class DrugService {

    @Autowired(required = false)
    DrugMapper drugMapper;

    public ArrayList<DrugDto> selectDrug() {

        ArrayList<DrugDto> drugResult = drugMapper.selectDrugInfo();

        return drugResult;

    }

}
