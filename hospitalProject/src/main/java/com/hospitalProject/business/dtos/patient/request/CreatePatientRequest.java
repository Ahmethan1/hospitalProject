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
public class CreatePatientRequest {
    @NotBlank(message = "TC No cannot be empty")
    @Pattern(regexp = "^[0-9]{11}$", message = "TC No must be exactly 11 digits long and contain only numbers")
    private String tcNo;

    @NotBlank(message = "First name cannot be empty")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "First name can only contain letters")
    private String firstName;

    @NotBlank(message = "Last name cannot be empty")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Last name can only contain letters")
    private String lastName;


    private String password;
}
