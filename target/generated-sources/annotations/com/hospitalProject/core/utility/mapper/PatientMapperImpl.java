package com.hospitalProject.core.utility.mapper;

import com.hospitalProject.business.dtos.patient.request.CreatePatientRequest;
import com.hospitalProject.business.dtos.patient.request.UpdatePatientRequest;
import com.hospitalProject.business.dtos.patient.response.CreatedPatientResponse;
import com.hospitalProject.business.dtos.patient.response.GetAllPatientResponse;
import com.hospitalProject.business.dtos.patient.response.GetByIdPatientResponse;
import com.hospitalProject.business.dtos.patient.response.LoginPatientResponse;
import com.hospitalProject.business.dtos.patient.response.UpdatedPatientResponse;
import com.hospitalProject.entity.Patient;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-24T16:49:29+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class PatientMapperImpl implements PatientMapper {

    @Override
    public Patient createRequestPatientToPatientEntity(CreatePatientRequest createPatientRequest) {
        if ( createPatientRequest == null ) {
            return null;
        }

        Patient patient = new Patient();

        patient.setTcNo( createPatientRequest.getTcNo() );
        patient.setFirstName( createPatientRequest.getFirstName() );
        patient.setLastName( createPatientRequest.getLastName() );
        patient.setPassword( createPatientRequest.getPassword() );

        return patient;
    }

    @Override
    public CreatedPatientResponse patientEntityToCreatedPatientResponse(Patient patient) {
        if ( patient == null ) {
            return null;
        }

        CreatedPatientResponse createdPatientResponse = new CreatedPatientResponse();

        createdPatientResponse.setId( patient.getId() );
        createdPatientResponse.setTcNo( patient.getTcNo() );
        createdPatientResponse.setFirstName( patient.getFirstName() );
        createdPatientResponse.setLastName( patient.getLastName() );

        return createdPatientResponse;
    }

    @Override
    public Patient updateRequestPatientToPatientEntity(UpdatePatientRequest updatePatientRequest) {
        if ( updatePatientRequest == null ) {
            return null;
        }

        Patient patient = new Patient();

        patient.setId( updatePatientRequest.getId() );
        patient.setTcNo( updatePatientRequest.getTcNo() );
        patient.setFirstName( updatePatientRequest.getFirstName() );
        patient.setLastName( updatePatientRequest.getLastName() );
        patient.setPassword( updatePatientRequest.getPassword() );

        return patient;
    }

    @Override
    public UpdatedPatientResponse patientEntityToUpdatedPatientResponse(Patient patient) {
        if ( patient == null ) {
            return null;
        }

        UpdatedPatientResponse updatedPatientResponse = new UpdatedPatientResponse();

        updatedPatientResponse.setId( patient.getId() );
        updatedPatientResponse.setTcNo( patient.getTcNo() );
        updatedPatientResponse.setFirstName( patient.getFirstName() );
        updatedPatientResponse.setLastName( patient.getLastName() );

        return updatedPatientResponse;
    }

    @Override
    public GetAllPatientResponse patientEntityToGetAllPatientResponse(Patient patient) {
        if ( patient == null ) {
            return null;
        }

        GetAllPatientResponse getAllPatientResponse = new GetAllPatientResponse();

        getAllPatientResponse.setId( patient.getId() );
        getAllPatientResponse.setTcNo( patient.getTcNo() );
        getAllPatientResponse.setFirstName( patient.getFirstName() );
        getAllPatientResponse.setLastName( patient.getLastName() );

        return getAllPatientResponse;
    }

    @Override
    public GetByIdPatientResponse patientEntityToGetByIdPatientResponse(Patient patient) {
        if ( patient == null ) {
            return null;
        }

        GetByIdPatientResponse getByIdPatientResponse = new GetByIdPatientResponse();

        getByIdPatientResponse.setId( patient.getId() );
        getByIdPatientResponse.setTcNo( patient.getTcNo() );
        getByIdPatientResponse.setFirstName( patient.getFirstName() );
        getByIdPatientResponse.setLastName( patient.getLastName() );

        return getByIdPatientResponse;
    }

    @Override
    public LoginPatientResponse patientEntityToLoginPatientResponse(Patient patient) {
        if ( patient == null ) {
            return null;
        }

        LoginPatientResponse loginPatientResponse = new LoginPatientResponse();

        loginPatientResponse.setId( patient.getId() );
        loginPatientResponse.setTcNo( patient.getTcNo() );
        loginPatientResponse.setFirstName( patient.getFirstName() );
        loginPatientResponse.setLastName( patient.getLastName() );

        return loginPatientResponse;
    }
}
