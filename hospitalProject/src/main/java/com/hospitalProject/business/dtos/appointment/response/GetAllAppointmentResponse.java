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
public class GetAllAppointmentResponse {
    private UUID id;
    private LocalDateTime appointmentDate;
    private String firstName;
    private String lastName;
    private UUID doctorId;
    private String doctorFirstName;
    private String doctorLastName;
    private UUID patientId;
    private String tcNo;

}
