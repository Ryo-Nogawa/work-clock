package io.github.ryonogawa.workclock.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Getter;

@Table("attendance_records")
@Getter
public class AttendanceRecords {

    @Id
    @Column("id")
    private long id;

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

    public AttendanceRecords(long userId) {
        this.userId = userId;
        this.recordDate = LocalDate.now();
        this.clockInTime = LocalDateTime.now();
        this.status = "IN_PROGRESS";
        this.updatedAt = LocalDateTime.now();
        this.createdAt = LocalDateTime.now();
    }

}
