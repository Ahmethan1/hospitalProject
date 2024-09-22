package com.hospitalProject.business.dtos.patient.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreatePatientRequest {
    private String tcNo;
    private String firstName;
    private String lastName;
    private String password;
}
