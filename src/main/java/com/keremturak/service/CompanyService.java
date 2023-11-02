package com.keremturak.service;

import com.keremturak.dto.request.CompanySaveRequestDto;
import com.keremturak.dto.request.CompanyUpdateRequestDto;
import com.keremturak.dto.response.CompanyFindAllResponseDto;
import com.keremturak.dto.response.CompanyResponseDto;
import com.keremturak.dto.response.CompanySaveResponseDto;
import com.keremturak.exception.EErrorType;
import com.keremturak.exception.MyCompanyException;
import com.keremturak.mapper.IMapper;
import com.keremturak.repository.ICompanyRepository;
import com.keremturak.repository.entity.Company;
import com.keremturak.repository.entity.Employee;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class CompanyService {
    private final ICompanyRepository companyRepository;
    private final EmployeeService employeeService;
    CompanyService(ICompanyRepository companyRepository, EmployeeService employeeService) {
        this.companyRepository = companyRepository;
        this.employeeService = employeeService;
    }
    public CompanySaveResponseDto save(CompanySaveRequestDto dto) {
        if (dto == null) {
            throw new MyCompanyException(EErrorType.DTO_IS_NULL);
        }
        Company company = IMapper.INSTANCE.companyFromCompanySaveRequestDto(dto);
        return IMapper.INSTANCE.companySaveResponseDtofromCompany(companyRepository.save(company));
    }

    public List<CompanyFindAllResponseDto>  findAll() {
        List<Company> companies = companyRepository.findAll();
        if (companies.isEmpty()){
            throw new MyCompanyException(EErrorType.COMPANY_NOT_BE_FOUND);
        }
        List<CompanyFindAllResponseDto> companyList = new ArrayList<>();
        companies.forEach(company -> companyList.add(IMapper.INSTANCE.companyFindAllResponseDtofromCompany(company)));
        return companyList;

    }

    public CompanyResponseDto updateCompany(CompanyUpdateRequestDto dto) {
        if (dto == null) {
            throw new MyCompanyException(EErrorType.DTO_IS_NULL);
        }
        Company company = Company.builder().companyName(dto.getCompanyName()).companyPhone(dto.getCompanyPhone()).id(dto.getId()).infoEmail(dto.getInfoEmail()).city(dto.getCity()).build();
        companyRepository.save(company);
        CompanyResponseDto responseDto = IMapper.INSTANCE.companyResponseDtofromCompany(company);
        return responseDto;
    }

    public String deleteCompany(String id) {
        Optional<Company> company = companyRepository.findById(id);
        if (company.isEmpty()) {
            throw new MyCompanyException(EErrorType.COMPANY_NOT_BE_FOUND);
        }
        employeeService.deleteAllByCompanyId(id);
        companyRepository.deleteById(id);
        return "Company deleted";
    }
}
