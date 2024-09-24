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
public class CreateDoctorRequest {
    @NotBlank(message = "First name cannot be empty")
    @Pattern(regexp = "^[^0-9]+$", message = "First name cannot contain numbers")
    private String firstName;

    @NotBlank(message = "Last name cannot be empty")
    @Pattern(regexp = "^[^0-9]+$", message = "Last name cannot contain numbers")
    private String lastName;

    @NotBlank(message = "Registration number cannot be empty")
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "Registration number can only contain alphanumeric characters")
    @Size(min = 6, max = 12, message = "Registration number must be between 6 and 12 characters long")
    private String registrationNumber;

    @NotBlank(message = "Password cannot be empty")
    @Size(min = 8, max = 20, message = "Password must be between 8 and 20 characters long")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]+$",
            message = "Password must contain at least one uppercase letter, one lowercase letter, one number, and one special character")
    private String password;

}
