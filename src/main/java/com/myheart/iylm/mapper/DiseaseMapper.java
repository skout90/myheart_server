package com.myheart.iylm.mapper;

import java.util.ArrayList;

import com.myheart.iylm.vo.DiseaseVo;

public interface DiseaseMapper {

	public ArrayList<DiseaseVo> selectDiseaseList(DiseaseVo diseaseVo);

	public DiseaseVo selectDiseaseView();

	public int insertDisease();

	public int updateDisease();

	public int deleteDisease();

}
