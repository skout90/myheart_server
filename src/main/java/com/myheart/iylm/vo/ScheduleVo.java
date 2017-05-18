package com.myheart.iylm.vo;

import java.util.Date;

/**
 * <pre>
 * Class Name  : ScheduleVo.java
 * Description : 스케줄 Vo
 * Modification Information
 *
 *    수정일　　　 　　  수정자　　　     수정내용
 *    ────────────   ─────────   ───────────────────────────────
 *    2017. 3. 24.   남준호              최초생성
 * </pre>
 *
 * @author 남준호
 * @since 2017. 3. 24.
 * @version 1.0
 *
 * Copyright (C) 2017 by MyHeart All right reserved.
 */
public class ScheduleVo {
    // 스케줄 일련번호
    Integer schNo;
    // 복용 시작일
    Date startDt;
    // 복용 종료일
    Date endDt;
    // 시간 구분
    String timeDivision;
    // 푸시 시간
    String pushTime;
    // 디바이스 토큰
    String deviceToken;

    public Integer getSchNo() {
        return schNo;
    }

    public void setSchNo(Integer schNo) {
        this.schNo = schNo;
    }

    public Date getStartDt() {
        return startDt;
    }

    public void setStartDt(Date startDt) {
        this.startDt = startDt;
    }

    public Date getEndDt() {
        return endDt;
    }

    public void setEndDt(Date endDt) {
        this.endDt = endDt;
    }

    public String getTimeDivision() {
        return timeDivision;
    }

    public void setTimeDivision(String timeDivision) {
        this.timeDivision = timeDivision;
    }

    public String getPushTime() {
        return pushTime;
    }

    public void setPushTime(String pushTime) {
        this.pushTime = pushTime;
    }

    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

}
