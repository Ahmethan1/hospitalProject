package com.hospitalProject.business.dtos.appointment.response;

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
public class GetByIdAppointmentResponse {

    private UUID id;
    private LocalDateTime appointmentDate;
    private String status;
    private String doctorFirstName;
    private String patientFirstName;
}
