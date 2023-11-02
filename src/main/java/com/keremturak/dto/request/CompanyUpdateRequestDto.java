package com.keremturak.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyUpdateRequestDto {
    @NotEmpty(message = "Name field cannot be empty")
    private String id;
    @NotEmpty(message = "Name field cannot be empty")
    private String companyName;
    @NotEmpty(message = "Name field cannot be empty")
    private String companyPhone;
    @Email(message = "Email must be valid")
    private String infoEmail;
    @NotEmpty(message = "Name field cannot be empty")
    private String city;
}
