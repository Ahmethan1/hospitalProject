package com.hospitalProject.business.abstracts;

import com.hospitalProject.business.dtos.doctor.request.CreateDoctorRequest;
import com.hospitalProject.business.dtos.doctor.request.LoginDoctorRequest;
import com.hospitalProject.business.dtos.doctor.request.UpdateDoctorRequest;
import com.hospitalProject.business.dtos.doctor.response.*;
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
    LoginDoctorResponse login(LoginDoctorRequest loginDoctorRequest);
}
