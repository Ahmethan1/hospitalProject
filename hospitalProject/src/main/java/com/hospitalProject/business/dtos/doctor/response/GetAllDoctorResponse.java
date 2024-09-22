package com.hospitalProject.business.dtos.doctor.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetAllDoctorResponse {
    private UUID id;
    private String firstName;
    private String lastName;

}
