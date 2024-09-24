package com.hospitalProject.business.concretes;

import com.hospitalProject.business.abstracts.DoctorService;
import com.hospitalProject.business.dtos.doctor.request.CreateDoctorRequest;
import com.hospitalProject.business.dtos.doctor.request.LoginDoctorRequest;
import com.hospitalProject.business.dtos.doctor.request.UpdateDoctorRequest;
import com.hospitalProject.business.dtos.doctor.response.*;
import com.hospitalProject.business.messages.DoctorMessages;
import com.hospitalProject.core.utility.exceptions.types.BusinessException;
import com.hospitalProject.core.utility.mapper.DoctorMapper;
import com.hospitalProject.dataAccess.DoctorRepository;
import com.hospitalProject.entity.Doctor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DoctorManager implements DoctorService {
    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;

    @Override
    public CreatedDoctorResponse add(CreateDoctorRequest createDoctorRequest) {
        this.checkIfDoctorExistByRegistrationNumber(createDoctorRequest.getRegistrationNumber());

        Doctor doctor = this.doctorMapper.createDoctorRequestToDoctorEntity(createDoctorRequest);
        doctor.setCreatedDate(LocalDateTime.now());

        Doctor savedDoctor = this.doctorRepository.save(doctor);

        return this.doctorMapper.doctorEntityToCreatedDoctorResponse(savedDoctor);
    }

    @Override
    public Page<GetAllDoctorResponse> getAll(Pageable pageable) {
        Page<Doctor> doctorList = this.doctorRepository.findAllByDeletedDateIsNullOrderByIdAsc(pageable);

        return doctorList.map(this.doctorMapper::doctorEntityToGetAllDoctorResponse);
    }

    @Override
    public UpdatedDoctorResponse update(UpdateDoctorRequest updateDoctorRequest) {
        this.checkIfDoctorExists(updateDoctorRequest.getId());
        Doctor doctor = this.doctorMapper.updateDoctorRequestToDoctorEntity(updateDoctorRequest);
        doctor.setUpdatedDate(LocalDateTime.now());

        Doctor updatedDoctor = this.doctorRepository.save(doctor);
        return this.doctorMapper.doctorEntityToUpdatedDoctorResponse(updatedDoctor);
    }

    @Override
    public GetByIdDoctorResponse getById(UUID id) {
        Doctor doctor = this.doctorRepository.findById(id).orElse(null);
        return this.doctorMapper.doctorEntityToGetByIdDoctorResponse(doctor);
    }

    @Override
    public LoginDoctorResponse login(LoginDoctorRequest loginDoctorRequest) {
        Doctor doctor = this.doctorRepository.findByRegistrationNumberAndDeletedDateIsNull(loginDoctorRequest.getRegistrationNumber())
                .orElseThrow(()-> new BusinessException(DoctorMessages.INVALID_PASSWORD));

        if (!doctor.getPassword().equals(loginDoctorRequest.getPassword())){
            throw new BusinessException(DoctorMessages.INVALID_PASSWORD);
        }
        return this.doctorMapper.doctorEntityToLoginDoctorResponse(doctor);
    }

    @Override
    public void delete(UUID id) {
        Doctor doctor = this.doctorRepository.findByIdAndDeletedDateIsNull(id).orElseThrow(() -> new BusinessException(DoctorMessages.DOCTOR_ALREADY_DELETED));
        doctor.setDeletedDate(LocalDateTime.now());
        this.doctorRepository.save(doctor);

    }

    private void checkIfDoctorExists(UUID id) {
        Optional<Doctor> doctor = this.doctorRepository.findByIdAndDeletedDateIsNull(id);
        if (doctor.isEmpty()) {
            throw new BusinessException(DoctorMessages.DOCTOR_ID_NOT_FOUND);
        }
    }

    private void checkIfDoctorExistByRegistrationNumber(String registrationNumber) {
        Optional<Doctor> doctor = this.doctorRepository.findByRegistrationNumber(registrationNumber);
        if (doctor.isPresent()) {
            throw new BusinessException(DoctorMessages.DOCTOR_ALREADY_EXIST);
        }
    }


}
