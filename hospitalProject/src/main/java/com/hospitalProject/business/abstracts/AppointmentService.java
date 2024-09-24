package com.hospitalProject.business.abstracts;

import com.hospitalProject.business.dtos.appointment.request.CreateAppointmentRequest;
import com.hospitalProject.business.dtos.appointment.request.UpdateAppointmentRequest;
import com.hospitalProject.business.dtos.appointment.response.CreatedAppoinmentResponse;
import com.hospitalProject.business.dtos.appointment.response.GetAllAppointmentResponse;
import com.hospitalProject.business.dtos.appointment.response.GetByIdAppointmentResponse;
import com.hospitalProject.business.dtos.appointment.response.UpdatedAppointmentResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface AppointmentService {
    CreatedAppoinmentResponse add(CreateAppointmentRequest createAppointmentRequest);
    UpdatedAppointmentResponse update(UpdateAppointmentRequest updateAppointmentRequest);
    GetByIdAppointmentResponse getById(UUID id);
    Page<GetAllAppointmentResponse> getAll(Pageable pageable);
    void delete(UUID id);
}
