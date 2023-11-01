package com.keremturak.mapper;


import com.keremturak.dto.request.CompanySaveRequestDto;
import com.keremturak.dto.request.EmployeeSaveRequestDto;
import com.keremturak.dto.response.*;
import com.keremturak.repository.entity.Company;
import com.keremturak.repository.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "string", unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface IMapper {

    IMapper INSTANCE = Mappers.getMapper(IMapper.class);

    Company companyFromCompanySaveRequestDto(final CompanySaveRequestDto dto);

    CompanySaveResponseDto companySaveResponseDtofromCompany(final Company save);


    CompanyFindAllResponseDto companyFindAllResponseDtofromCompany(final Company company);


    CompanyResponseDto companyResponseDtofromCompany(Company company);


    //Employee

    Employee employeeFromEmployeeSaveRequestDto(final EmployeeSaveRequestDto employeeSaveRequestDto);
    EmployeeSaveResponseDto employeeSaveResponseDtofromEmployee(final Employee employee);
    EmployeeFindAllResponseDto employeeFindAllResponseDtofromCompany(final Employee employee);

    EmployeeResponseDto employeeResponseDtofromCompany(final Employee x);

}
