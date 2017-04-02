package com.myheart.iylm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myheart.iylm.service.DiseaseService;
import com.myheart.iylm.vo.DiseaseVo;

/**
 * <pre>
 * Class Name  : DiseaseController.java
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
@RestController
@RequestMapping(value = "/disease")
public class DiseaseController {

	@Autowired(required = false)
	DiseaseService diseaseService;

	/**
	 * @Author 김민균
	 * @Comment 질병 목록
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<DiseaseVo> selectDiseaseList(HttpServletRequest req) {

		String searchType = req.getParameter("searchType");
		String searchName = req.getParameter("searchName");
		Integer page = (Integer) ((req.getParameter("page") == null) ? 0 : req.getParameter("page"));
		Integer count = (Integer) ((req.getParameter("count") == null) ? 10 : req.getParameter("count"));
		Integer offset = (page - 1) * count;
		Integer limit = count;

		Map<String, Object> param = new HashMap<String, Object>();
		param.put("searchType", searchType);
		param.put("searchName", searchName);
		param.put("offset", offset);
		param.put("limit", limit);

		List<DiseaseVo> result = diseaseService.selectDiseaseList(param);
		System.out.println(result);
		return result;
	}

	@RequestMapping(value = "disease/insert", method = RequestMethod.POST)
	public List<DiseaseVo> insertDisease(Locale locale, Model model) {

		//model.addAttribute("drugSelect", drugService.selectDrug());
		List<DiseaseVo> result = new ArrayList<DiseaseVo>();
		DiseaseVo dto = new DiseaseVo();

		result.add(dto);
		return result;
	}

	@RequestMapping(value = "disease/delete", method = RequestMethod.POST)
	public List<DiseaseVo> deleteDisease(Locale locale, Model model) {

		//model.addAttribute("drugSelect", drugService.selectDrug());
		List<DiseaseVo> result = new ArrayList<DiseaseVo>();
		DiseaseVo dto = new DiseaseVo();

		result.add(dto);
		return result;
	}

	@RequestMapping(value = "disease/update", method = RequestMethod.POST)
	public List<DiseaseVo> updateDisease(Locale locale, Model model) {

		//model.addAttribute("drugSelect", drugService.selectDrug());
		List<DiseaseVo> result = new ArrayList<DiseaseVo>();
		DiseaseVo dto = new DiseaseVo();

		result.add(dto);
		return result;
	}

}
