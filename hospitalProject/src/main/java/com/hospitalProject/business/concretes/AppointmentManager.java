package com.hospitalProject.business.concretes;

import com.hospitalProject.business.abstracts.AppointmentService;
import com.hospitalProject.business.dtos.appointment.request.CreateAppointmentRequest;
import com.hospitalProject.business.dtos.appointment.request.UpdateAppointmentRequest;
import com.hospitalProject.business.dtos.appointment.response.CreatedAppoinmentResponse;
import com.hospitalProject.business.dtos.appointment.response.GetAllAppointmentResponse;
import com.hospitalProject.business.dtos.appointment.response.GetByIdAppointmentResponse;
import com.hospitalProject.business.dtos.appointment.response.UpdatedAppointmentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AppointmentManager implements AppointmentService {
    @Override
    public CreatedAppoinmentResponse add(CreateAppointmentRequest createAppointmentRequest) {
        return null;
    }

    @Override
    public UpdatedAppointmentResponse update(UpdateAppointmentRequest updateAppointmentRequest) {
        return null;
    }

    @Override
    public GetByIdAppointmentResponse getById(UUID id) {
        return null;
    }

    @Override
    public GetAllAppointmentResponse getAll() {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }
}
