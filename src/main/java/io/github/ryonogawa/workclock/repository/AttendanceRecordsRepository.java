package io.github.ryonogawa.workclock.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;

import io.github.ryonogawa.workclock.entity.AttendanceRecords;

public interface AttendanceRecordsRepository {
    // 出勤登録
    public void clockIn(long userId);

    // 退勤登録
    public int clockOut(long id, LocalDateTime clockOutTime, String status, LocalDateTime updatedAt);

    // 勤怠情報取得
    public AttendanceRecords getAttendanceInfo(long userId, LocalDate recordDate);
}
