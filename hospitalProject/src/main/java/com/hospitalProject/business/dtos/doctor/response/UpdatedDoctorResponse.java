package com.hospitalProject.business.dtos.doctor.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdatedDoctorResponse {
    private String firstName;
    private String lastName;
    private String registrationNumber;

}
