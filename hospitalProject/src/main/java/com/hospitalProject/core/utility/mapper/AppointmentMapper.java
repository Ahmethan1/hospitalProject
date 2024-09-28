package com.hospitalProject.core.utility.mapper;

import com.hospitalProject.business.dtos.appointment.request.CreateAppointmentRequest;
import com.hospitalProject.business.dtos.appointment.request.UpdateAppointmentRequest;
import com.hospitalProject.business.dtos.appointment.response.CreatedAppoinmentResponse;
import com.hospitalProject.business.dtos.appointment.response.GetAllAppointmentResponse;
import com.hospitalProject.business.dtos.appointment.response.GetByIdAppointmentResponse;
import com.hospitalProject.business.dtos.appointment.response.UpdatedAppointmentResponse;
import com.hospitalProject.entity.Appointment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface AppointmentMapper {
    @Mapping(source = "doctorId", target = "doctor.id")
    @Mapping(source = "patientId", target = "patient.id")
    Appointment createRequestAppointmentToAppointmentEntity(CreateAppointmentRequest createAppointmentRequest);
    @Mapping(source = "doctor.id", target = "doctorId")
    @Mapping(source = "patient.id", target = "patientId")
    CreatedAppoinmentResponse appointmentEntityToCreatedAppointmentResponse(Appointment appointment);

    @Mapping(source = "doctorId", target = "doctor.id")
    @Mapping(source = "patientId", target = "patient.id")
    Appointment updateRequestAppointmentToAppointmentEntity(UpdateAppointmentRequest updateAppointmentRequest);
    @Mapping(source = "doctor.id", target = "doctorId")
    @Mapping(source = "patient.id", target = "patientId")
    UpdatedAppointmentResponse appointmentEntityToUpdatedAppointmentResponse(Appointment appointment);


    GetByIdAppointmentResponse appointmentEntityToGetByIdAppointmentResponse(Appointment appointment);
    @Mapping(source = "patient.firstName", target = "firstName")
    @Mapping(source = "patient.lastName", target = "lastName")
    @Mapping(source ="appointment.id" ,target = "id")
    @Mapping(source = "patient.tcNo",target = "tcNo")
    @Mapping(source = "doctor.id", target = "doctorId")
    @Mapping(source = "patient.id", target = "patientId")
    @Mapping(source = "doctor.firstName",target = "doctorFirstName")
    @Mapping(source = "doctor.lastName",target = "doctorLastName")
    GetAllAppointmentResponse appoinmentEntityToGetAllAppointmentResponse(Appointment appointment);
}
