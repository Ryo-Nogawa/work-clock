package io.github.ryonogawa.workclock.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Getter;
import lombok.With;

@Table("attendance_records")
@Getter
@With
public class AttendanceRecords {

    @Id
    @Column("id")
    private Long id;

    @Column("user_id")
    private long userId;

    @Column("record_date")
    private LocalDate recordDate;

    @Column("clock_in_time")
    private LocalDateTime clockInTime;

    @Column("clock_out_time")
    private LocalDateTime clockOutTime;

    @Column("status")
    private String status;

    @Column("updated_at")
    private LocalDateTime updatedAt;

    @Column("created_at")
    private LocalDateTime createdAt;

    public AttendanceRecords(Long id, long userId, LocalDate recordDate, LocalDateTime clockInTime,
            LocalDateTime clockOutTime, String status, LocalDateTime updatedAt, LocalDateTime createdAt) {
        this.id = id;
        this.userId = userId;
        this.recordDate = recordDate;
        this.clockInTime = clockInTime;
        this.clockOutTime = clockOutTime;
        this.status = status;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
    }

    public static AttendanceRecords forClockIn(long userId) {
        return new AttendanceRecords(null, userId, LocalDate.now(), LocalDateTime.now(),
                null, "IN_PROGRESS", LocalDateTime.now(), LocalDateTime.now());
    }
}
