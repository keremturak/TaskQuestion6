package com.keremturak.controller;

import com.keremturak.dto.request.EmployeeSaveRequestDto;
import com.keremturak.dto.request.EmployeeUpdateRequestDto;
import com.keremturak.dto.response.CompanyFindAllResponseDto;
import com.keremturak.dto.response.EmployeeFindAllResponseDto;
import com.keremturak.dto.response.EmployeeResponseDto;
import com.keremturak.dto.response.EmployeeSaveResponseDto;
import com.keremturak.repository.entity.Company;
import com.keremturak.repository.entity.Employee;
import com.keremturak.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import static com.keremturak.constant.ApiUrls.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(EMPLOYEE)
public class EmployeeController {

    private final EmployeeService employeeService;
    @PostMapping(SAVE_EMPLOYEE)
    public ResponseEntity<EmployeeSaveResponseDto> save(@RequestBody @Valid EmployeeSaveRequestDto employeeSaveRequestDto) {
        return ResponseEntity.ok(employeeService.save(employeeSaveRequestDto));
    }
    @GetMapping(FIND_ALL_EMPLOYEE)
    public ResponseEntity<List<EmployeeFindAllResponseDto>> findAll() {
        return ResponseEntity.ok(employeeService.findAll());
    }
    @GetMapping(FIND_ALL_BY_COMPANY_ID)
    public ResponseEntity<List<EmployeeResponseDto>> findAllByCompanyId(String companyId) {
        return ResponseEntity.ok(employeeService.findAllByCompanyId(companyId));
    }
    @GetMapping(FIND_BY_COMPANY_NAME_AND_EMPLOYEE_NAME)
    public ResponseEntity<List<EmployeeResponseDto>> findByCompanyNameAndEmployeeName(String companyId, String employeeName) {
        return ResponseEntity.ok(employeeService.findByCompanyNameAndEmployeeName(companyId, employeeName));
    }
    @PutMapping(UPDATE_EMPLOYEE)
    public ResponseEntity<EmployeeResponseDto> updateByCompanyId(@RequestBody EmployeeUpdateRequestDto dto){
        return ResponseEntity.ok(employeeService.updateByEmployeeId(dto));
    }
    @DeleteMapping(DELETE_EMPLOYEE + "/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable String id){
        return ResponseEntity.ok(employeeService.deleteEmployee(id));
    }

}
