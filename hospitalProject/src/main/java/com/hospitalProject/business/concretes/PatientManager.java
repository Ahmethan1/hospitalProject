package com.hospitalProject.business.concretes;

import com.hospitalProject.business.abstracts.PatientService;
import com.hospitalProject.business.dtos.patient.request.CreatePatientRequest;
import com.hospitalProject.business.dtos.patient.request.UpdatePatientRequest;
import com.hospitalProject.business.dtos.patient.response.CreatedPatientResponse;
import com.hospitalProject.business.dtos.patient.response.GetAllPatientResponse;
import com.hospitalProject.business.dtos.patient.response.GetByIdPatientResponse;
import com.hospitalProject.business.dtos.patient.response.UpdatedPatientResponse;
import com.hospitalProject.core.utility.mapper.PatientMapper;
import com.hospitalProject.dataAccess.PatientRepository;
import com.hospitalProject.entity.Patient;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PatientManager implements PatientService {
    private final PatientMapper patientMapper;
    private final PatientRepository patientRepository;

    @Override
    public CreatedPatientResponse add(CreatePatientRequest createPatientRequest) {
        Patient patient = this.patientMapper.createRequestPatientToPatientEntity(createPatientRequest);
        patient.setCreatedDate(LocalDateTime.now());

        Patient savedPatient = this.patientRepository.save(patient);
        return this.patientMapper.patientEntityToCreatedPatientResponse(savedPatient);
    }

    @Override
    public UpdatedPatientResponse update(UpdatePatientRequest updatePatientRequest) {
        Patient patient = this.patientMapper.updateRequestPatientToPatientEntity(updatePatientRequest);
        patient.setUpdatedDate(LocalDateTime.now());

        Patient savedPatient = this.patientRepository.save(patient);
        return this.patientMapper.patientEntityToUpdatedPatientResponse(savedPatient);
    }

    @Override
    public Page<GetAllPatientResponse> getAll(Pageable pageable) {
        Page<Patient> patients = this.patientRepository.findAllByDeletedDateIsNullOrderByIdAsc(pageable);

        return patients.map(this.patientMapper::patientEntityToGetAllPatientResponse);
    }

    @Override
    public GetByIdPatientResponse getById(UUID id) {
        Patient patient = this.patientRepository.findByIdAndDeletedDateIsNull(id)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found with id: "));
        return this.patientMapper.patientEntityToGetByIdPatientResponse(patient);
    }

    @Override
    public void delete(UUID id) {
        Patient patient = this.patientRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Patient not found"));
        patient.setDeletedDate(LocalDateTime.now());
        this.patientRepository.save(patient);

    }
}
