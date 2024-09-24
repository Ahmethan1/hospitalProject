package com.hospitalProject.business.concretes;

import com.hospitalProject.business.abstracts.AppointmentService;
import com.hospitalProject.business.abstracts.DoctorService;
import com.hospitalProject.business.abstracts.PatientService;
import com.hospitalProject.business.dtos.appointment.request.CreateAppointmentRequest;
import com.hospitalProject.business.dtos.appointment.request.UpdateAppointmentRequest;
import com.hospitalProject.business.dtos.appointment.response.CreatedAppoinmentResponse;
import com.hospitalProject.business.dtos.appointment.response.GetAllAppointmentResponse;
import com.hospitalProject.business.dtos.appointment.response.GetByIdAppointmentResponse;
import com.hospitalProject.business.dtos.appointment.response.UpdatedAppointmentResponse;
import com.hospitalProject.business.messages.AppointmentMessages;
import com.hospitalProject.core.utility.exceptions.types.BusinessException;
import com.hospitalProject.core.utility.mapper.AppointmentMapper;
import com.hospitalProject.dataAccess.AppointmentRepository;
import com.hospitalProject.entity.Appointment;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AppointmentManager implements AppointmentService {
    private final AppointmentMapper appointmentMapper;
    private final AppointmentRepository appointmentRepository;
    private final DoctorService doctorService;
    private final PatientService patientService;

    @Override
    public CreatedAppoinmentResponse add(CreateAppointmentRequest createAppointmentRequest) {
        this.checkIfDoctorExists(createAppointmentRequest.getDoctorId());
        this.checkIfAppointmentExists(createAppointmentRequest.getAppointmentDate(), createAppointmentRequest.getDoctorId());

        Appointment appointment = this.appointmentMapper.createRequestAppointmentToAppointmentEntity(createAppointmentRequest);
        appointment.setCreatedDate(LocalDateTime.now());

        Appointment savedAppointment = this.appointmentRepository.save(appointment);
        return this.appointmentMapper.appointmentEntityToCreatedAppointmentResponse(savedAppointment);
    }

    @Override
    public UpdatedAppointmentResponse update(UpdateAppointmentRequest updateAppointmentRequest) {
        this.checkIfAppointmentExists(updateAppointmentRequest.getId());
        this.checkIfDoctorExists(updateAppointmentRequest.getDoctorId());
        this.checkIfAppointmentExists(updateAppointmentRequest.getAppointmentDate(), updateAppointmentRequest.getDoctorId());

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
    public Page<GetAllAppointmentResponse> getAll(Pageable pageable) {
        Page<Appointment> appointments = this.appointmentRepository.findAllByDeletedDateIsNullOrderByIdAsc(pageable);

        return appointments.map(this.appointmentMapper::appoinmentEntityToGetAllAppointmentResponse);
    }

    @Override
    public void delete(UUID id) {
        Appointment appointment = this.appointmentRepository.findByIdAndDeletedDateIsNull(id)
                .orElseThrow(() -> new BusinessException(AppointmentMessages.APPOINTMENT_ALREADY_DELETED));
        appointment.setDeletedDate(LocalDateTime.now());
        this.appointmentRepository.save(appointment);
    }

    private void checkIfAppointmentExists(UUID id) {
        Optional<Appointment> appointment = this.appointmentRepository.findByIdAndDeletedDateIsNull(id);
        if (appointment.isEmpty()) {
            throw new BusinessException(AppointmentMessages.APPOINTMENT_ID_NOT_FOUND);
        }
    }

    private void checkIfDoctorExists(UUID doctorId) {
        if (doctorService.getById(doctorId) == null) {
            throw new BusinessException(AppointmentMessages.DOCTOR_NOT_FOUND);
        }
    }

    private void checkIfPatientExists(UUID patientId) {
        if (patientService.getById(patientId) == null) {
            throw new BusinessException(AppointmentMessages.PATIENT_NOT_FOUND);
        }
    }

    private void checkIfAppointmentExists(LocalDateTime appointmentDate, UUID doctorId) {

        Optional<Appointment> existingAppointment = appointmentRepository.findByAppointmentDateAndDoctorId(appointmentDate, doctorId);
        if (existingAppointment.isPresent()) {
            throw new BusinessException(AppointmentMessages.APPOINTMENT_ALREADY_EXIST);
        }
    }


}
