package io.github.ryonogawa.workclock.service;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import io.github.ryonogawa.workclock.entity.AttendanceRecords;
import io.github.ryonogawa.workclock.repository.AttendanceRecordsRepository;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    private final AttendanceRecordsRepository repository;

    public AttendanceServiceImpl(AttendanceRecordsRepository repository) {
        this.repository = repository;
    }

    @Override
    public void clockIn(long userId) {
        validateUserId(userId);
        repository.clockIn(userId);
    }

    @Override
    public void clockOut(long userId) {
        validateUserId(userId);

        // 出勤記録の取得
        LocalDate today = LocalDate.now();
        AttendanceRecords record = repository.getAttendanceInfo(userId, today);

        if (record == null) {
            System.out.println("本日の出勤記録がありません");
        }

        // 退勤登録
        LocalDateTime now = LocalDateTime.now();
        int clockOutResult = repository.clockOut(record.getId(), now, "COMPLETED", now);

        if (clockOutResult == 0) {
            System.out.println("退勤記録が正常に登録できませんでした");
        }
    }

    private void validateUserId(long userId) {
        if (userId <= 0) {
            throw new IllegalArgumentException("userIdは0より大きい値を指定してください");
        }
    }
}
