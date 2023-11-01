package com.keremturak.service;

import com.keremturak.dto.request.EmployeeSaveRequestDto;
import com.keremturak.dto.request.EmployeeUpdateRequestDto;
import com.keremturak.dto.response.EmployeeFindAllResponseDto;
import com.keremturak.dto.response.EmployeeResponseDto;
import com.keremturak.dto.response.EmployeeSaveResponseDto;
import com.keremturak.exception.EErrorType;
import com.keremturak.exception.MyCompanyException;
import com.keremturak.mapper.IMapper;
import com.keremturak.repository.ICompanyRepository;
import com.keremturak.repository.IEmployeeRepository;
import com.keremturak.repository.entity.Company;
import com.keremturak.repository.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final IEmployeeRepository employeeRepository;
    private final ICompanyRepository companyRepository;
    public EmployeeService(IEmployeeRepository employeeRepository,ICompanyRepository companyRepository) {
        this.employeeRepository = employeeRepository;
        this.companyRepository = companyRepository;
    }
    public EmployeeSaveResponseDto save(EmployeeSaveRequestDto employeeSaveRequestDto) {
        Optional<Company> company = companyRepository.findById(employeeSaveRequestDto.getCompanyId());
        if (company.isEmpty()){
            throw new MyCompanyException(EErrorType.COMPANY_NOT_BE_FOUND);
        }
        Employee employee = IMapper.INSTANCE.employeeFromEmployeeSaveRequestDto(employeeSaveRequestDto);
        EmployeeSaveResponseDto responseDto = IMapper.INSTANCE.employeeSaveResponseDtofromEmployee(employeeRepository.save(employee));
        responseDto.setCompanyName(company.get().getCompanyName());
        return responseDto;
    }

    public List<EmployeeFindAllResponseDto> findAll() {
        List<Employee> employees = employeeRepository.findAll();
        if (employees.isEmpty()) {
            throw new MyCompanyException(EErrorType.EMPLOYEE_NOT_BE_FOUND);
        }
        List<EmployeeFindAllResponseDto> employeeList = new ArrayList<>();
        employees.forEach(x -> employeeList.add(IMapper.INSTANCE.employeeFindAllResponseDtofromCompany(x)));
        return employeeList;
    }

    public List<EmployeeResponseDto> findAllByCompanyId(String companyId) {
        List<Employee> employees = employeeRepository.findAllByCompanyId(companyId);
        if (employees.isEmpty()) {
            throw new MyCompanyException(EErrorType.EMPLOYEE_NOT_BE_FOUND);
        }
        String CompanyName =companyRepository.findById(companyId).get().getCompanyName();
        List<EmployeeResponseDto> employeeList = new ArrayList<>();
        employees.forEach(x -> employeeList.add(IMapper.INSTANCE.employeeResponseDtofromCompany(x)));
        employeeList.forEach(x -> x.setCompanyName(CompanyName));
        return employeeList;
    }

    public List<EmployeeResponseDto> findByCompanyNameAndEmployeeName(String companyId, String employeeName) {
        List<Employee> employees = employeeRepository.findAllByCompanyId(companyId);
        if (employees.isEmpty()) {
            throw new MyCompanyException(EErrorType.EMPLOYEE_NOT_BE_FOUND);
        }
        List<Employee> filteredEmployees = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getFirstName().contains(employeeName)) {
                filteredEmployees.add(employee);
            }
        }
        if (filteredEmployees.isEmpty()) {
            throw new MyCompanyException(EErrorType.EMPLOYEE_NAME_NOT_FOUND);
        }
        List<EmployeeResponseDto> employeeResponseList = new ArrayList<>();
        filteredEmployees.forEach(x ->employeeResponseList.add(IMapper.INSTANCE.employeeResponseDtofromCompany(x)));
        return employeeResponseList;
    }

    public EmployeeResponseDto updateByEmployeeId(EmployeeUpdateRequestDto dto) {
        Optional<Employee> employee = employeeRepository.findById(dto.getId());
        if (employee.isEmpty()) {
            throw new MyCompanyException(EErrorType.EMPLOYEE_NOT_BE_FOUND);
        }
        employee.get().setCompanyId(dto.getCompanyId());
        employee.get().setRole(dto.getRole());
        String companyName = companyRepository.findById(dto.getCompanyId()).get().getCompanyName();
        EmployeeResponseDto responseDto =  IMapper.INSTANCE.employeeResponseDtofromCompany(employeeRepository.save(employee.get()));
        responseDto.setCompanyName(companyName);
        return responseDto;
    }

    public String deleteEmployee(String id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isEmpty()) {
            throw new MyCompanyException(EErrorType.EMPLOYEE_NOT_BE_FOUND);
        }
        employeeRepository.deleteById(id);
        return "Employee deleted";
    }

    public void deleteAllByCompanyId(String id) {
        List<Employee> deletedEmployees = employeeRepository.findAllByCompanyId(id);
        for (Employee employee : deletedEmployees) {
            employeeRepository.deleteById(employee.getId());
        }
    }
}
