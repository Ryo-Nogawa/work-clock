package io.github.ryonogawa.workclock.service;

import org.springframework.stereotype.Service;

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

    private void validateUserId(long userId) {
        if (userId <= 0) {
            throw new IllegalArgumentException("userIdは0より大きい値を指定してください");
        }
    }
}
