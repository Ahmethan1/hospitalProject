package com.hospitalProject.business.abstracts;

import com.hospitalProject.business.dtos.doctor.request.CreateDoctorRequest;
import com.hospitalProject.business.dtos.doctor.request.UpdateDoctorRequest;
import com.hospitalProject.business.dtos.doctor.response.CreatedDoctorResponse;
import com.hospitalProject.business.dtos.doctor.response.GetAllDoctorResponse;
import com.hospitalProject.business.dtos.doctor.response.GetByIdDoctorResponse;
import com.hospitalProject.business.dtos.doctor.response.UpdatedDoctorResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface DoctorService {
    CreatedDoctorResponse add(CreateDoctorRequest createDoctorRequest);
    Page<GetAllDoctorResponse> getAll(Pageable pageable);
    UpdatedDoctorResponse update(UpdateDoctorRequest updateDoctorRequest);
    void delete(UUID id);
    GetByIdDoctorResponse getById(UUID id);
}
