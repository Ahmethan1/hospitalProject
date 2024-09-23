package com.hospitalProject.dataAccess;

import com.hospitalProject.entity.Doctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface DoctorRepository extends JpaRepository<Doctor, UUID> {
    List<Doctor> findByDeletedDateIsNull();
    Page<Doctor> findAllByOrderByIdAsc(Pageable pageable);
}
