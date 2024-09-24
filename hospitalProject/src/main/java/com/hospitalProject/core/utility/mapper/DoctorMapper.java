package com.hospitalProject.core.utility.mapper;

import com.hospitalProject.business.dtos.doctor.request.CreateDoctorRequest;
import com.hospitalProject.business.dtos.doctor.request.LoginDoctorRequest;
import com.hospitalProject.business.dtos.doctor.request.UpdateDoctorRequest;
import com.hospitalProject.business.dtos.doctor.response.*;
import com.hospitalProject.entity.Doctor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DoctorMapper {
    Doctor createDoctorRequestToDoctorEntity(CreateDoctorRequest createDoctorRequest);
    CreatedDoctorResponse doctorEntityToCreatedDoctorResponse(Doctor doctor);

    Doctor updateDoctorRequestToDoctorEntity(UpdateDoctorRequest updateDoctorRequest);
    UpdatedDoctorResponse doctorEntityToUpdatedDoctorResponse(Doctor doctor);

    GetAllDoctorResponse doctorEntityToGetAllDoctorResponse(Doctor doctor);

    GetByIdDoctorResponse doctorEntityToGetByIdDoctorResponse(Doctor doctor);

    Doctor loginDoctorRequestToDoctorEntity(LoginDoctorRequest loginDoctorRequest);
    @Mapping(source = "doctor.registrationNumber", target = "registrationNumber")
    @Mapping(source = "doctor.firstName" , target = "name")
    LoginDoctorResponse doctorEntityToLoginDoctorResponse(Doctor doctor);

}
