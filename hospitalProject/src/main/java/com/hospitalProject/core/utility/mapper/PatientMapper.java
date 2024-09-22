package com.hospitalProject.core.utility.mapper;

import com.hospitalProject.business.dtos.patient.request.CreatePatientRequest;
import com.hospitalProject.business.dtos.patient.request.UpdatePatientRequest;
import com.hospitalProject.business.dtos.patient.response.CreatedPatientResponse;
import com.hospitalProject.business.dtos.patient.response.GetAllPatientResponse;
import com.hospitalProject.business.dtos.patient.response.GetByIdPatientResponse;
import com.hospitalProject.business.dtos.patient.response.UpdatedPatientResponse;
import com.hospitalProject.entity.Patient;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PatientMapper {
    Patient createRequestPatientToPatientEntity(CreatePatientRequest createPatientRequest);
    CreatedPatientResponse patientEntityToCreatedPatientResponse(Patient patient);

    Patient updateRequestPatientToPatientEntity(UpdatePatientRequest updatePatientRequest);
    UpdatedPatientResponse patientEntityToUpdatedPatientResponse(Patient patient);

    GetAllPatientResponse patientEntityToGetAllPatientResponse(Patient patient);
    GetByIdPatientResponse patientEntityToGetByIdPatientResponse(Patient patient);

}
