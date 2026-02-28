package io.github.ryonogawa.workclock.service;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.ryonogawa.workclock.entity.AttendanceRecords;
import io.github.ryonogawa.workclock.repository.AttendanceRecordsRepository;

@Service
@Transactional
public class AttendanceServiceImpl implements AttendanceService {

    private final AttendanceRecordsRepository repository;

    public AttendanceServiceImpl(AttendanceRecordsRepository repository) {
        this.repository = repository;
    }

    @Override
    public void clockIn(long userId) {
        validateUserId(userId);
        repository.save(AttendanceRecords.forClockIn(userId));
    }

    @Override
    public void clockOut(long userId) {
        validateUserId(userId);

        AttendanceRecords record = repository.findByUserIdAndRecordDate(userId, LocalDate.now())
                .orElse(null);

        if (record == null) {
            System.out.println("本日の出勤記録がありません");
            return;
        }

        LocalDateTime now = LocalDateTime.now();
        repository.save(record.withClockOutTime(now).withStatus("COMPLETED").withUpdatedAt(now));
    }

    private void validateUserId(long userId) {
        if (userId <= 0) {
            throw new IllegalArgumentException("userIdは0より大きい値を指定してください");
        }
    }
}
