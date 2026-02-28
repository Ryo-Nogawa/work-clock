package io.github.ryonogawa.workclock.repository;

import java.time.LocalDate;

import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import io.github.ryonogawa.workclock.entity.AttendanceRecords;

@Repository
public class AttendanceRecordsRepositoryImpl implements AttendanceRecordsRepository {

    private final JdbcTemplate jdbcTemplate;

    public AttendanceRecordsRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void clockIn(long userId) {
        AttendanceRecords clockInRecord = new AttendanceRecords(userId);
        jdbcTemplate.update(
                "INSERT INTO attendance_records  (user_id, record_date, clock_in_time, status, updated_at, created_at) VALUES (?,?,?,?,?,?)",
                clockInRecord.getUserId(),
                clockInRecord.getRecordDate(),
                clockInRecord.getClockInTime(),
                clockInRecord.getStatus(),
                clockInRecord.getUpdatedAt(),
                clockInRecord.getCreatedAt());
    }

    @Override
    public AttendanceRecords getAttendanceInfo(long userId, LocalDate recordDate) {
        AttendanceRecords record = jdbcTemplate.queryForObject(
                "SELECT id, user_id, record_date, clock_in_time, clock_out_time, status, updated_at, created_at FROM attendance_records WHERE user_id=? AND record_date=?",
                new DataClassRowMapper<>(AttendanceRecords.class), userId, recordDate);
        return record;

    }
}
