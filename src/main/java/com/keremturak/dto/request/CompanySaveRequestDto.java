package com.keremturak.dto.request;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanySaveRequestDto {
    @NotEmpty(message = "Name field cannot be empty")
    private String companyName;
    @NotEmpty(message = "Name field cannot be empty")
    @Size(min = 3, max = 20, message = "Name must be between 3 and 20 characters.")
    private String companyPhone;
    @Email(message = "Email must be valid")
    private String infoEmail;
    @NotEmpty(message = "City field cannot be empty")
    private String city;
}
