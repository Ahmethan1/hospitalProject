package com.hospitalProject.core.utility.mapper;

import com.hospitalProject.business.dtos.doctor.request.CreateDoctorRequest;
import com.hospitalProject.business.dtos.doctor.request.UpdateDoctorRequest;
import com.hospitalProject.business.dtos.doctor.response.CreatedDoctorResponse;
import com.hospitalProject.business.dtos.doctor.response.GetAllDoctorResponse;
import com.hospitalProject.business.dtos.doctor.response.GetByIdDoctorResponse;
import com.hospitalProject.business.dtos.doctor.response.UpdatedDoctorResponse;
import com.hospitalProject.entity.Doctor;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-22T19:42:03+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class DoctorMapperImpl implements DoctorMapper {

    @Override
    public Doctor createDoctorRequestToDoctorEntity(CreateDoctorRequest createDoctorRequest) {
        if ( createDoctorRequest == null ) {
            return null;
        }

        Doctor doctor = new Doctor();

        doctor.setFirstName( createDoctorRequest.getFirstName() );
        doctor.setLastName( createDoctorRequest.getLastName() );
        doctor.setRegistrationNumber( createDoctorRequest.getRegistrationNumber() );
        doctor.setPassword( createDoctorRequest.getPassword() );

        return doctor;
    }

    @Override
    public CreatedDoctorResponse doctorEntityToCreatedDoctorResponse(Doctor doctor) {
        if ( doctor == null ) {
            return null;
        }

        CreatedDoctorResponse createdDoctorResponse = new CreatedDoctorResponse();

        createdDoctorResponse.setId( doctor.getId() );
        createdDoctorResponse.setFirstName( doctor.getFirstName() );
        createdDoctorResponse.setLastName( doctor.getLastName() );

        return createdDoctorResponse;
    }

    @Override
    public Doctor updateDoctorRequestToDoctorEntity(UpdateDoctorRequest updateDoctorRequest) {
        if ( updateDoctorRequest == null ) {
            return null;
        }

        Doctor doctor = new Doctor();

        doctor.setId( updateDoctorRequest.getId() );
        doctor.setFirstName( updateDoctorRequest.getFirstName() );
        doctor.setLastName( updateDoctorRequest.getLastName() );
        doctor.setRegistrationNumber( updateDoctorRequest.getRegistrationNumber() );
        doctor.setPassword( updateDoctorRequest.getPassword() );

        return doctor;
    }

    @Override
    public UpdatedDoctorResponse doctorEntityToUpdatedDoctorResponse(Doctor doctor) {
        if ( doctor == null ) {
            return null;
        }

        UpdatedDoctorResponse updatedDoctorResponse = new UpdatedDoctorResponse();

        updatedDoctorResponse.setFirstName( doctor.getFirstName() );
        updatedDoctorResponse.setLastName( doctor.getLastName() );
        updatedDoctorResponse.setRegistrationNumber( doctor.getRegistrationNumber() );

        return updatedDoctorResponse;
    }

    @Override
    public GetAllDoctorResponse doctorEntityToGetAllDoctorResponse(Doctor doctor) {
        if ( doctor == null ) {
            return null;
        }

        GetAllDoctorResponse getAllDoctorResponse = new GetAllDoctorResponse();

        getAllDoctorResponse.setId( doctor.getId() );
        getAllDoctorResponse.setFirstName( doctor.getFirstName() );
        getAllDoctorResponse.setLastName( doctor.getLastName() );

        return getAllDoctorResponse;
    }

    @Override
    public GetByIdDoctorResponse doctorEntityToGetByIdDoctorResponse(Doctor doctor) {
        if ( doctor == null ) {
            return null;
        }

        GetByIdDoctorResponse getByIdDoctorResponse = new GetByIdDoctorResponse();

        getByIdDoctorResponse.setId( doctor.getId() );
        getByIdDoctorResponse.setFirstName( doctor.getFirstName() );
        getByIdDoctorResponse.setLastName( doctor.getLastName() );
        getByIdDoctorResponse.setRegistrationNumber( doctor.getRegistrationNumber() );

        return getByIdDoctorResponse;
    }
}
