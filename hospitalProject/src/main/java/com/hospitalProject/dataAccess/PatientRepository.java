package com.hospitalProject.dataAccess;

import com.hospitalProject.entity.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PatientRepository extends JpaRepository<Patient, UUID> {
    Page<Patient> findAllByDeletedDateIsNullOrderByIdAsc(Pageable pageable);

    Optional<Patient> findByIdAndDeletedDateIsNull(UUID id);
}
