package com.hospitalProject.core.utility.mapper;

import com.hospitalProject.business.dtos.appointment.request.CreateAppointmentRequest;
import com.hospitalProject.business.dtos.appointment.request.UpdateAppointmentRequest;
import com.hospitalProject.business.dtos.appointment.response.CreatedAppoinmentResponse;
import com.hospitalProject.business.dtos.appointment.response.GetAllAppointmentResponse;
import com.hospitalProject.business.dtos.appointment.response.GetByIdAppointmentResponse;
import com.hospitalProject.business.dtos.appointment.response.UpdatedAppointmentResponse;
import com.hospitalProject.entity.Appointment;
import com.hospitalProject.entity.Doctor;
import com.hospitalProject.entity.Patient;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-23T15:04:55+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class AppointmentMapperImpl implements AppointmentMapper {

    @Override
    public Appointment createRequestAppointmentToAppointmentEntity(CreateAppointmentRequest createAppointmentRequest) {
        if ( createAppointmentRequest == null ) {
            return null;
        }

        Appointment appointment = new Appointment();

        appointment.setDoctor( createAppointmentRequestToDoctor( createAppointmentRequest ) );
        appointment.setPatient( createAppointmentRequestToPatient( createAppointmentRequest ) );
        appointment.setAppointmentDate( createAppointmentRequest.getAppointmentDate() );
        appointment.setStatus( createAppointmentRequest.getStatus() );

        return appointment;
    }

    @Override
    public CreatedAppoinmentResponse appointmentEntityToCreatedAppointmentResponse(Appointment appointment) {
        if ( appointment == null ) {
            return null;
        }

        CreatedAppoinmentResponse createdAppoinmentResponse = new CreatedAppoinmentResponse();

        createdAppoinmentResponse.setDoctorId( appointmentDoctorId( appointment ) );
        createdAppoinmentResponse.setPatientId( appointmentPatientId( appointment ) );
        createdAppoinmentResponse.setId( appointment.getId() );
        createdAppoinmentResponse.setAppointmentDate( appointment.getAppointmentDate() );
        createdAppoinmentResponse.setStatus( appointment.getStatus() );

        return createdAppoinmentResponse;
    }

    @Override
    public Appointment updateRequestAppointmentToAppointmentEntity(UpdateAppointmentRequest updateAppointmentRequest) {
        if ( updateAppointmentRequest == null ) {
            return null;
        }

        Appointment appointment = new Appointment();

        appointment.setId( updateAppointmentRequest.getId() );
        appointment.setAppointmentDate( updateAppointmentRequest.getAppointmentDate() );
        appointment.setStatus( updateAppointmentRequest.getStatus() );

        return appointment;
    }

    @Override
    public UpdatedAppointmentResponse appointmentEntityToUpdatedAppointmentResponse(Appointment appointment) {
        if ( appointment == null ) {
            return null;
        }

        UpdatedAppointmentResponse updatedAppointmentResponse = new UpdatedAppointmentResponse();

        updatedAppointmentResponse.setId( appointment.getId() );
        updatedAppointmentResponse.setAppointmentDate( appointment.getAppointmentDate() );
        updatedAppointmentResponse.setStatus( appointment.getStatus() );

        return updatedAppointmentResponse;
    }

    @Override
    public GetByIdAppointmentResponse appointmentEntityToGetByIdAppointmentResponse(Appointment appointment) {
        if ( appointment == null ) {
            return null;
        }

        GetByIdAppointmentResponse getByIdAppointmentResponse = new GetByIdAppointmentResponse();

        getByIdAppointmentResponse.setId( appointment.getId() );
        getByIdAppointmentResponse.setAppointmentDate( appointment.getAppointmentDate() );
        getByIdAppointmentResponse.setStatus( appointment.getStatus() );

        return getByIdAppointmentResponse;
    }

    @Override
    public GetAllAppointmentResponse appoinmentEntityToGetAllAppointmentResponse(Appointment appointment) {
        if ( appointment == null ) {
            return null;
        }

        GetAllAppointmentResponse getAllAppointmentResponse = new GetAllAppointmentResponse();

        getAllAppointmentResponse.setId( appointment.getId() );
        getAllAppointmentResponse.setAppointmentDate( appointment.getAppointmentDate() );
        getAllAppointmentResponse.setStatus( appointment.getStatus() );

        return getAllAppointmentResponse;
    }

    protected Doctor createAppointmentRequestToDoctor(CreateAppointmentRequest createAppointmentRequest) {
        if ( createAppointmentRequest == null ) {
            return null;
        }

        Doctor doctor = new Doctor();

        doctor.setId( createAppointmentRequest.getDoctorId() );

        return doctor;
    }

    protected Patient createAppointmentRequestToPatient(CreateAppointmentRequest createAppointmentRequest) {
        if ( createAppointmentRequest == null ) {
            return null;
        }

        Patient patient = new Patient();

        patient.setId( createAppointmentRequest.getPatientId() );

        return patient;
    }

    private UUID appointmentDoctorId(Appointment appointment) {
        if ( appointment == null ) {
            return null;
        }
        Doctor doctor = appointment.getDoctor();
        if ( doctor == null ) {
            return null;
        }
        UUID id = doctor.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private UUID appointmentPatientId(Appointment appointment) {
        if ( appointment == null ) {
            return null;
        }
        Patient patient = appointment.getPatient();
        if ( patient == null ) {
            return null;
        }
        UUID id = patient.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
