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
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

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
    public List<GetAllPatientResponse> getAll() {
        List<Patient> patients = this.patientRepository.findAll();

        return patients.stream().map(this.patientMapper::patientEntityToGetAllPatientResponse).collect(Collectors.toList());
    }

    @Override
    public GetByIdPatientResponse getById(UUID id) {
        Patient patient = this.patientRepository.findById(id).orElse(null);
        return this.patientMapper.patientEntityToGetByIdPatientResponse(patient);
    }

    @Override
    public void delete(UUID id) {
        Optional<Patient> patient = this.patientRepository.findById(id);
        this.patientRepository.deleteById(id);

    }
}
