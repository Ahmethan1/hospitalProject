package com.hospitalProject.business.dtos.patient.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoginPatientResponse {
    private UUID id;
    private String tcNo;
    private String firstName;
    private String lastName;
}
