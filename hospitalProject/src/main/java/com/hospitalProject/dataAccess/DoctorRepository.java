package com.hospitalProject.dataAccess;

import com.hospitalProject.entity.Doctor;
import com.hospitalProject.entity.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DoctorRepository extends JpaRepository<Doctor, UUID> {
    Page<Doctor> findAllByDeletedDateIsNullOrderByIdAsc(Pageable pageable);
    Page<Doctor> findAllByOrderByIdAsc(Pageable pageable);
    Optional<Doctor> findByIdAndDeletedDateIsNull(UUID id);
    Optional<Doctor> findByRegistrationNumber(String registrationNumber);
    Optional<Doctor> findByRegistrationNumberAndDeletedDateIsNull(String registrationNumber);

}
