package com.hospitalProject.dataAccess;

import com.hospitalProject.entity.Appointment;
import com.hospitalProject.entity.Doctor;
import com.hospitalProject.entity.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

public interface AppointmentRepository extends JpaRepository<Appointment, UUID> {
    Page<Appointment> findAllByDeletedDateIsNullOrderByIdAsc(Pageable pageable);
    Optional<Appointment> findByIdAndDeletedDateIsNull(UUID id);
    Optional<Appointment> findByAppointmentDateAndDoctorId(LocalDateTime appointmentDate, UUID doctorId);

    //Optional<Appointment> findByTcNo(String tcNo);
}
