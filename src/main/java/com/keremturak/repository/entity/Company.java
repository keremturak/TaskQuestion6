package com.keremturak.repository.entity;



import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;


@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Document
public class Company{
    @Id
   private String id;
    private String companyName;
    private String companyPhone;
    private String infoEmail;
    private String city;
}
