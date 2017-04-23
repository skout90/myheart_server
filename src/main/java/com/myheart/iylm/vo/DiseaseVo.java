package com.myheart.iylm.vo;

import com.myheart.iylm.CommonVo;

/**
 * <pre>
 * Class Name  : DiseaseVo.java
 * Description :
 * Modification Information
 *
 *    수정일　　　 　　  수정자　　　     수정내용
 *    ────────────   ─────────   ───────────────────────────────
 *    2017. 4. 2.   김민균              최초생성
 * </pre>
 *
 * @author 김민균
 * @since 2017. 4. 2.
 * @version 1.0
 *
 * Copyright (C) 2017 by MyHeart All right reserved.
 */
public class DiseaseVo extends CommonVo {
	// 질병 코드
	private String diseaseCd;
	// 질병명
	private String diseaseNm;
	// 질병명(영어)
	private String diseaseNmEn;
	// 주 질병 타입
	private String typeCd1;
	// 서브 질병 타입
	private String typeCd2;

	public String getDiseaseCd() {
		return diseaseCd;
	}

	public void setDiseaseCd(String diseaseCd) {
		this.diseaseCd = diseaseCd;
	}

	public String getDiseaseNm() {
		return diseaseNm;
	}

	public void setDiseaseNm(String diseaseNm) {
		this.diseaseNm = diseaseNm;
	}

	public String getDiseaseNmEn() {
		return diseaseNmEn;
	}

	public void setDiseaseNmEn(String diseaseNmEn) {
		this.diseaseNmEn = diseaseNmEn;
	}

	public String getTypeCd1() {
		return typeCd1;
	}

	public void setTypeCd1(String typeCd1) {
		this.typeCd1 = typeCd1;
	}

	public String getTypeCd2() {
		return typeCd2;
	}

	public void setTypeCd2(String typeCd2) {
		this.typeCd2 = typeCd2;
	}

}
