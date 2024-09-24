package com.hospitalProject.business.dtos.patient.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoginPatientRequest {
    private String tcNo;
    private String password;
}
