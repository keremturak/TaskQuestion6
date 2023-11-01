package com.keremturak.dto.request;

import com.keremturak.repository.enums.ERole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeUpdateRequestDto {
    @Id
    private String id;
    private String companyId;
    private ERole role;
}
