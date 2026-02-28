package io.github.ryonogawa.workclock.service;

public interface AttendanceService {
    // 出勤登録
    public void clockIn(long userId);

    // 退勤登録
    public void clockOut(long userId) throws Exception;
}
