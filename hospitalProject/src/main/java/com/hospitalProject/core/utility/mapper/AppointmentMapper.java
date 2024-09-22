package com.hospitalProject.core.utility.mapper;

import com.hospitalProject.business.dtos.appointment.request.CreateAppointmentRequest;
import com.hospitalProject.business.dtos.appointment.request.UpdateAppointmentRequest;
import com.hospitalProject.business.dtos.appointment.response.CreatedAppoinmentResponse;
import com.hospitalProject.business.dtos.appointment.response.GetAllAppointmentResponse;
import com.hospitalProject.business.dtos.appointment.response.GetByIdAppointmentResponse;
import com.hospitalProject.business.dtos.appointment.response.UpdatedAppointmentResponse;
import com.hospitalProject.entity.Appointment;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface AppointmentMapper {
    Appointment createRequestAppointmentToAppointmentEntity(CreateAppointmentRequest createAppointmentRequest);
    CreatedAppoinmentResponse appointmentEntityToCreatedAppointmentResponse(Appointment appointment);

    Appointment updateRequestAppointmentToAppointmentEntity(UpdateAppointmentRequest updateAppointmentRequest);
    UpdatedAppointmentResponse appointmentEntityToUpdatedAppointmentResponse(Appointment appointment);

    GetByIdAppointmentResponse appointmentEntityToGetByIdAppointmentResponse(Appointment appointment);
    GetAllAppointmentResponse appoinmentEntityToGetAllAppointmentResponse(Appointment appointment);
}
