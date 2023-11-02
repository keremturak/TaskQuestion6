package com.keremturak.dto.request;

import com.keremturak.repository.enums.ERole;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeSaveRequestDto {
    @NotEmpty(message = "companyId field cannot be empty")
    private String companyId;
    @NotEmpty(message = "firstName field cannot be empty")
    private String firstName;
    @NotEmpty(message = "lastName field cannot be empty")
    private String lastName;
    private ERole role;
}
