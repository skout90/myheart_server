package com.myheart.iylm.mapper;

import java.util.ArrayList;
import java.util.Map;

import com.myheart.iylm.vo.DiseaseVo;

public interface DiseaseMapper {

	public ArrayList<DiseaseVo> selectDiseaseList(Map<String, Object> param);

	public DiseaseVo selectDiseaseView();

	public int insertDisease();

	public int updateDisease();

	public int deleteDisease();

}
