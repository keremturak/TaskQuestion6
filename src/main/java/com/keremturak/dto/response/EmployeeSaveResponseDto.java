package com.keremturak.dto.response;

import com.keremturak.repository.enums.ERole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeSaveResponseDto {
    private String companyId;
    private String firstName;
    private String lastName;
    @Builder.Default
    private ERole role=ERole.EMPLOYEE;
    private String companyName;
}
