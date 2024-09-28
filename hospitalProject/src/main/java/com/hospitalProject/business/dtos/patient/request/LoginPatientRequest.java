package com.hospitalProject.business.dtos.patient.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoginPatientRequest {
    @NotBlank(message = "TC No cannot be empty")
    @Pattern(regexp = "^[0-9]{11}$", message = "TC No must be 11 digits long and contain only numbers")
    private String tcNo;


    private String password;
}
