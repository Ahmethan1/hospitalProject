package com.hospitalProject.business.concretes;

import com.hospitalProject.business.abstracts.DoctorService;
import com.hospitalProject.business.dtos.doctor.request.CreateDoctorRequest;
import com.hospitalProject.business.dtos.doctor.request.UpdateDoctorRequest;
import com.hospitalProject.business.dtos.doctor.response.CreatedDoctorResponse;
import com.hospitalProject.business.dtos.doctor.response.GetAllDoctorResponse;
import com.hospitalProject.business.dtos.doctor.response.GetByIdDoctorResponse;
import com.hospitalProject.business.dtos.doctor.response.UpdatedDoctorResponse;
import com.hospitalProject.core.utility.mapper.DoctorMapper;
import com.hospitalProject.dataAccess.DoctorRepository;
import com.hospitalProject.entity.Doctor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DoctorManager implements DoctorService {
    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;
    @Override
    public CreatedDoctorResponse add(CreateDoctorRequest createDoctorRequest) {
        Doctor doctor =this.doctorMapper.createDoctorRequestToDoctorEntity(createDoctorRequest);
        doctor.setCreatedDate(LocalDateTime.now());

        Doctor savedDoctor = this.doctorRepository.save(doctor);

        return this.doctorMapper.doctorEntityToCreatedDoctorResponse(savedDoctor);
    }

    @Override
    public List<GetAllDoctorResponse> getAll() {
        List<Doctor> doctorList = this.doctorRepository.findAll();

        return doctorList.stream()
                .map(this.doctorMapper :: doctorEntityToGetAllDoctorResponse).collect(Collectors.toList());
    }

    @Override
    public UpdatedDoctorResponse update(UpdateDoctorRequest updateDoctorRequest) {
        Doctor doctor = this.doctorMapper.updateDoctorRequestToDoctorEntity(updateDoctorRequest);
        doctor.setUpdatedDate(LocalDateTime.now());

        Doctor updatedDoctor =this.doctorRepository.save(doctor);
        return this.doctorMapper.doctorEntityToUpdatedDoctorResponse(updatedDoctor);
    }

    @Override
    public GetByIdDoctorResponse getById(UUID id) {
        Doctor doctor = this.doctorRepository.findById(id).orElse(null);
        return this.doctorMapper.doctorEntityToGetByIdDoctorResponse(doctor);
    }

    @Override
    public void delete(UUID id) {
        Optional<Doctor> doctor = this.doctorRepository.findById(id);

        this.doctorRepository.deleteById(id);

    }


}
