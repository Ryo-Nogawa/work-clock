package io.github.ryonogawa.workclock.repository;

public interface AttendanceRecordsRepository {
    // 出勤登録
    public void clockIn(long userId);
}
