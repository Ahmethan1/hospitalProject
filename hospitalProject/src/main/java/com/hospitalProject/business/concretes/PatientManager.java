package com.hospitalProject.business.concretes;

import com.hospitalProject.business.abstracts.PatientService;
import com.hospitalProject.business.dtos.patient.request.CreatePatientRequest;
import com.hospitalProject.business.dtos.patient.request.UpdatePatientRequest;
import com.hospitalProject.business.dtos.patient.response.CreatedPatientResponse;
import com.hospitalProject.business.dtos.patient.response.GetAllPatientResponse;
import com.hospitalProject.business.dtos.patient.response.GetByIdPatientResponse;
import com.hospitalProject.business.dtos.patient.response.UpdatedPatientResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PatientManager implements PatientService {
    @Override
    public CreatedPatientResponse add(CreatePatientRequest createPatientRequest) {
        return null;
    }

    @Override
    public UpdatedPatientResponse update(UpdatePatientRequest updatePatientRequest) {
        return null;
    }

    @Override
    public GetAllPatientResponse getAll() {
        return null;
    }

    @Override
    public GetByIdPatientResponse getById(UUID id) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }
}
