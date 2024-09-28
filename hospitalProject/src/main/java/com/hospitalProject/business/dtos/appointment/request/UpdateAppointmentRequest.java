package com.hospitalProject.business.dtos.appointment.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateAppointmentRequest {
    private UUID id;
    @NotNull(message = "Appointment date cannot be empty")
    private LocalDateTime appointmentDate;
    private String status;

    @NotNull(message = "Doctor ID cannot be empty")
    private UUID doctorId;

    @NotNull(message = "Patient ID cannot be empty")
    private UUID patientId;
}
