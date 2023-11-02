package com.keremturak.repository.entity;


import com.keremturak.repository.enums.ERole;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document
public class Employee{
    @Id
    private String id;
    private String companyId;
    private String firstName;
    private String lastName;
    @Builder.Default
    private ERole role=ERole.EMPLOYEE;
}
