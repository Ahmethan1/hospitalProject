package com.hospitalProject.business.dtos.appointment.request;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateAppointmentRequest {
    private LocalDateTime appointmentDate;
    private String status;
    private UUID doctorId;
    private UUID patientId;
}
