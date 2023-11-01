package com.keremturak.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyUpdateRequestDto {
    private String id;
    private String companyName;
    private String companyPhone;
    private String infoEmail;
    private String city;
}
