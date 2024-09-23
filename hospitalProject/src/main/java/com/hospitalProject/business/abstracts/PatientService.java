package com.hospitalProject.business.abstracts;

import com.hospitalProject.business.dtos.patient.request.CreatePatientRequest;
import com.hospitalProject.business.dtos.patient.request.UpdatePatientRequest;
import com.hospitalProject.business.dtos.patient.response.CreatedPatientResponse;
import com.hospitalProject.business.dtos.patient.response.GetAllPatientResponse;
import com.hospitalProject.business.dtos.patient.response.GetByIdPatientResponse;
import com.hospitalProject.business.dtos.patient.response.UpdatedPatientResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface PatientService {
    CreatedPatientResponse add(CreatePatientRequest createPatientRequest);
    UpdatedPatientResponse update(UpdatePatientRequest updatePatientRequest);
    Page<GetAllPatientResponse> getAll(Pageable pageable);
    GetByIdPatientResponse getById(UUID id);
    void delete(UUID id);
}
