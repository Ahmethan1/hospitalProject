package com.hospitalProject.core.utility.mapper;

import com.hospitalProject.business.dtos.doctor.request.CreateDoctorRequest;
import com.hospitalProject.business.dtos.doctor.request.UpdateDoctorRequest;
import com.hospitalProject.business.dtos.doctor.response.CreatedDoctorResponse;
import com.hospitalProject.business.dtos.doctor.response.GetAllDoctorResponse;
import com.hospitalProject.business.dtos.doctor.response.GetByIdDoctorResponse;
import com.hospitalProject.business.dtos.doctor.response.UpdatedDoctorResponse;
import com.hospitalProject.entity.Doctor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DoctorMapper {
    Doctor createDoctorRequestToDoctorEntity(CreateDoctorRequest createDoctorRequest);
    CreatedDoctorResponse doctorEntityToCreatedDoctorResponse(Doctor doctor);

    Doctor updateDoctorRequestToDoctorEntity(UpdateDoctorRequest updateDoctorRequest);
    UpdatedDoctorResponse doctorEntityToUpdatedDoctorResponse(Doctor doctor);

    GetAllDoctorResponse doctorEntityToGetAllDoctorResponse(Doctor doctor);

    GetByIdDoctorResponse doctorEntityToGetByIdDoctorResponse(Doctor doctor);

}
