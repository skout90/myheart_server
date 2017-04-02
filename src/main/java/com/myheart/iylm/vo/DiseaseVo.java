package com.myheart.iylm.vo;

/*
 * DiseaseDto
 */
public class DiseaseVo {

	private String diseaseCd; /* 질병 코드 */
	private String diseaseNm; /* 질병 명칭 */
	private String diseaseNmEn; /* 질병 명칭(영) */
	private String diseaseCd1; /* 질병 분류1 */
	private String diseaseCd2; /* 질병 분류2 */

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

	public String getDiseaseCd1() {
		return diseaseCd1;
	}

	public void setDiseaseCd1(String diseaseCd1) {
		this.diseaseCd1 = diseaseCd1;
	}

	public String getDiseaseCd2() {
		return diseaseCd2;
	}

	public void setDiseaseCd2(String diseaseCd2) {
		this.diseaseCd2 = diseaseCd2;
	}

}
