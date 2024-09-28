package com.hospitalProject.business.dtos.doctor.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateDoctorRequest {
    @NotNull
    private UUID id;
    @NotNull(message = "This field is required")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "First name must contain only letters")
    @Size(min = 2, max = 50)
    private String firstName;

    @NotNull(message = "This field is required")
    @Size(min = 2, max = 50)
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Last name must contain only letters")
    private String lastName;

    @NotBlank(message = "Registration number cannot be empty")
    @Pattern(regexp = "^[0-9]{10}$", message = "Registration number must be exactly 10 digits")
    private String registrationNumber;


    private String password;


}
