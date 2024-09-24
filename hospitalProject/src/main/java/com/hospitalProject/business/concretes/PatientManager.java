package com.hospitalProject.business.concretes;

import com.hospitalProject.business.abstracts.PatientService;
import com.hospitalProject.business.dtos.patient.request.CreatePatientRequest;
import com.hospitalProject.business.dtos.patient.request.LoginPatientRequest;
import com.hospitalProject.business.dtos.patient.request.UpdatePatientRequest;
import com.hospitalProject.business.dtos.patient.response.*;
import com.hospitalProject.business.messages.PatientMessages;
import com.hospitalProject.core.utility.exceptions.types.BusinessException;
import com.hospitalProject.core.utility.mapper.PatientMapper;
import com.hospitalProject.dataAccess.PatientRepository;
import com.hospitalProject.entity.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PatientManager implements PatientService {
    private final PatientMapper patientMapper;
    private final PatientRepository patientRepository;


    @Override
    public CreatedPatientResponse add(CreatePatientRequest createPatientRequest) {
        this.checkIfPatientExistByTcNo(createPatientRequest.getTcNo());
        Patient patient = this.patientMapper.createRequestPatientToPatientEntity(createPatientRequest);
        patient.setCreatedDate(LocalDateTime.now());

        Patient savedPatient = this.patientRepository.save(patient);
        return this.patientMapper.patientEntityToCreatedPatientResponse(savedPatient);
    }

    @Override
    public UpdatedPatientResponse update(UpdatePatientRequest updatePatientRequest) {
        this.checkIfPatientExists(updatePatientRequest.getId());
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
        this.checkIfPatientExists(id);
        Patient patient = this.patientRepository.findById(id)
                .orElseThrow(() -> new BusinessException(PatientMessages.PATIENT_ID_NOT_FOUND));
        return this.patientMapper.patientEntityToGetByIdPatientResponse(patient);
    }

    @Override
    public void delete(UUID id) {
        Patient patient = this.patientRepository.findByIdAndDeletedDateIsNull(id)
                .orElseThrow(() -> new BusinessException(PatientMessages.PATIENT_ALREADY_DELETED));
        patient.setDeletedDate(LocalDateTime.now());
        this.patientRepository.save(patient);
    }

    @Override
    public LoginPatientResponse login(LoginPatientRequest loginPatientRequest) {
        Patient patient = this.patientRepository.findByTcNoAndDeletedDateIsNull(loginPatientRequest.getTcNo())
                .orElseThrow(() -> new BusinessException(PatientMessages.INVALID_PASSWORD));

        if(!patient.getPassword().equals(loginPatientRequest.getPassword())){
            throw new BusinessException(PatientMessages.INVALID_PASSWORD);
        }
        return this.patientMapper.patientEntityToLoginPatientResponse(patient);
    }

    private void checkIfPatientExists(UUID id) {
        Optional<Patient> patient = this.patientRepository.findByIdAndDeletedDateIsNull(id);
        if (patient.isEmpty()) {
            throw new BusinessException(PatientMessages.PATIENT_ID_NOT_FOUND);
        }
    }

    private void checkIfPatientExistByTcNo(String tcNo) {
        Optional<Patient> patient = this.patientRepository.findByTcNo(tcNo);
        if (patient.isPresent()) {
            throw new BusinessException(PatientMessages.PATIENT_ALREADY_EXIST);
        }
    }
}
