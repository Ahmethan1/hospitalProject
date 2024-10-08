package com.hospitalProject.business.dtos.doctor.request;

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
public class LoginDoctorRequest {
    @NotBlank(message = "Registration number cannot be empty")
    @Pattern(regexp = "^[0-9]{10}$", message = "Registration number must be exactly 10 digits")
    private String registrationNumber;



    private String password;
}
