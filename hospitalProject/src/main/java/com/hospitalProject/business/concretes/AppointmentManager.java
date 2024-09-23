package com.hospitalProject.business.concretes;

import com.hospitalProject.business.abstracts.AppointmentService;
import com.hospitalProject.business.abstracts.PatientService;
import com.hospitalProject.business.dtos.appointment.request.CreateAppointmentRequest;
import com.hospitalProject.business.dtos.appointment.request.UpdateAppointmentRequest;
import com.hospitalProject.business.dtos.appointment.response.CreatedAppoinmentResponse;
import com.hospitalProject.business.dtos.appointment.response.GetAllAppointmentResponse;
import com.hospitalProject.business.dtos.appointment.response.GetByIdAppointmentResponse;
import com.hospitalProject.business.dtos.appointment.response.UpdatedAppointmentResponse;
import com.hospitalProject.core.utility.mapper.AppointmentMapper;
import com.hospitalProject.dataAccess.AppointmentRepository;
import com.hospitalProject.entity.Appointment;
import com.hospitalProject.entity.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AppointmentManager implements AppointmentService {
    private final AppointmentMapper appointmentMapper;
    private final AppointmentRepository appointmentRepository;
    @Override
    public CreatedAppoinmentResponse add(CreateAppointmentRequest createAppointmentRequest) {
        //randevunun olup olmadığını kontrol edicem
        Appointment appointment = this.appointmentMapper.createRequestAppointmentToAppointmentEntity(createAppointmentRequest);
        appointment.setCreatedDate(LocalDateTime.now());

        Appointment savedAppointment = this.appointmentRepository.save(appointment);
        return this.appointmentMapper.appointmentEntityToCreatedAppointmentResponse(savedAppointment);
    }

    @Override
    public UpdatedAppointmentResponse update(UpdateAppointmentRequest updateAppointmentRequest) {
        // id kontrolünü yapıcam
        Appointment appointment = this.appointmentMapper.updateRequestAppointmentToAppointmentEntity(updateAppointmentRequest);
        appointment.setUpdatedDate(LocalDateTime.now());
        return null;
    }

    @Override
    public GetByIdAppointmentResponse getById(UUID id) {
        Appointment appointment = this.appointmentRepository.findById(id).orElse(null);

        return this.appointmentMapper.appointmentEntityToGetByIdAppointmentResponse(appointment);
    }

    @Override
    public List<GetAllAppointmentResponse> getAll() {
        List<Appointment> appointments = this.appointmentRepository.findAll();

        return appointments.stream().map(this.appointmentMapper::appoinmentEntityToGetAllAppointmentResponse).collect(Collectors.toList());
    }

    @Override
    public void delete(UUID id) {
        Optional<Appointment> appointment = this.appointmentRepository.findById(id);

        this.appointmentRepository.deleteById(id);
    }
}
