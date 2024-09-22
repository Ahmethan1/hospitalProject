package com.hospitalProject.business.dtos.appointment.request;

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
    private LocalDateTime appointmentDate;
    private String status;
    private UUID doctorId;
    private UUID patientId;
}
