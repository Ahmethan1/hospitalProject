package com.hospitalProject.business.abstracts;

import com.hospitalProject.business.dtos.appointment.request.CreateAppointmentRequest;
import com.hospitalProject.business.dtos.appointment.request.UpdateAppointmentRequest;
import com.hospitalProject.business.dtos.appointment.response.CreatedAppoinmentResponse;
import com.hospitalProject.business.dtos.appointment.response.GetAllAppointmentResponse;
import com.hospitalProject.business.dtos.appointment.response.GetByIdAppointmentResponse;
import com.hospitalProject.business.dtos.appointment.response.UpdatedAppointmentResponse;

import java.util.List;
import java.util.UUID;

public interface AppointmentService {
    CreatedAppoinmentResponse add(CreateAppointmentRequest createAppointmentRequest);
    UpdatedAppointmentResponse update(UpdateAppointmentRequest updateAppointmentRequest);
    GetByIdAppointmentResponse getById(UUID id);
    List<GetAllAppointmentResponse> getAll();
    void delete(UUID id);
}
