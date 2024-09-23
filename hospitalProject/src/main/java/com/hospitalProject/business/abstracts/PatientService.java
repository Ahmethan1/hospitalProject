package com.hospitalProject.business.abstracts;

import com.hospitalProject.business.dtos.patient.request.CreatePatientRequest;
import com.hospitalProject.business.dtos.patient.request.UpdatePatientRequest;
import com.hospitalProject.business.dtos.patient.response.CreatedPatientResponse;
import com.hospitalProject.business.dtos.patient.response.GetAllPatientResponse;
import com.hospitalProject.business.dtos.patient.response.GetByIdPatientResponse;
import com.hospitalProject.business.dtos.patient.response.UpdatedPatientResponse;

import java.util.List;
import java.util.UUID;

public interface PatientService {
    CreatedPatientResponse add(CreatePatientRequest createPatientRequest);
    UpdatedPatientResponse update(UpdatePatientRequest updatePatientRequest);
    List<GetAllPatientResponse> getAll();
    GetByIdPatientResponse getById(UUID id);
    void delete(UUID id);
}
