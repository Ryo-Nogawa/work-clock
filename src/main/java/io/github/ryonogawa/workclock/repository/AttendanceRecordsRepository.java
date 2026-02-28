package io.github.ryonogawa.workclock.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.repository.ListCrudRepository;

import io.github.ryonogawa.workclock.entity.AttendanceRecords;

public interface AttendanceRecordsRepository extends ListCrudRepository<AttendanceRecords, Long> {

    Optional<AttendanceRecords> findByUserIdAndRecordDate(long userId, LocalDate recordDate);
}
