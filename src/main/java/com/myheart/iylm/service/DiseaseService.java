package com.myheart.iylm.service;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myheart.iylm.mapper.DiseaseMapper;
import com.myheart.iylm.vo.DiseaseVo;

@Service("diseaseService")
public class DiseaseService {

	@Autowired(required = false)
	DiseaseMapper diseaseMapper;

	public ArrayList<DiseaseVo> selectDiseaseList(Map<String, Object> param) {

		ArrayList<DiseaseVo> diseaseList = diseaseMapper.selectDiseaseList(param);
		return diseaseList;

	}

}
