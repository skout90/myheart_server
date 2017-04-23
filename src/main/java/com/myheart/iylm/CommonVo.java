package com.myheart.iylm;

/**
 * <pre>
 * Class Name  : CommonVo.java
 * Description :
 * Modification Information
 *
 *    수정일　　　 　　  수정자　　　     수정내용
 *    ────────────   ─────────   ───────────────────────────────
 *    2017. 4. 14.   김민균              최초생성
 * </pre>
 *
 * @author 김민균
 * @since 2017. 4. 14.
 * @version 1.0
 *
 * Copyright (C) 2017 by MyHeart All right reserved.
 */
public class CommonVo {
	// 페이지
	private Integer page = 0;
	// 한 페이지당 개수
	private Integer count = 10;
	// select limit 시작
	private Integer offset;
	// select limit 끝
	private Integer limit;
	// 검색명
	private String searchName;
	// 검색 타입
	private String searchType;
	// 정렬순
	private String sortType = "DESC";

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getOffset() {
		offset = (getPage() - 1) * getCount();
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	public Integer getLimit() {
		limit = getCount();
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getSortType() {
		return sortType;
	}

	public void setSortType(String sortType) {
		this.sortType = sortType;
	}

}
