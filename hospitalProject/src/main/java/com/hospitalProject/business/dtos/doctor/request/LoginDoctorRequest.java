package com.hospitalProject.business.dtos.doctor.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoginDoctorRequest {
    private String registrationNumber;
    private String password;
}
