package com.keremturak.controller;

import com.keremturak.dto.request.CompanySaveRequestDto;
import com.keremturak.dto.request.CompanyUpdateRequestDto;
import com.keremturak.dto.response.CompanyFindAllResponseDto;
import com.keremturak.dto.response.CompanyResponseDto;
import com.keremturak.dto.response.CompanySaveResponseDto;
import com.keremturak.service.CompanyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.keremturak.constant.ApiUrls.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(COMPANY)
public class CompanyController {
    private final CompanyService companyService;

    @PostMapping (SAVE_COMPANY)
    public ResponseEntity<CompanySaveResponseDto> save(@RequestBody @Valid CompanySaveRequestDto dto) {
        return ResponseEntity.ok(companyService.save(dto));
    }
    @GetMapping (FIND_ALL_COMPANY)
    public ResponseEntity<List<CompanyFindAllResponseDto>> findAll() {
        return ResponseEntity.ok(companyService.findAll());
    }
    @PutMapping(UPDATE_COMPANY)
    public ResponseEntity<CompanyResponseDto> updateCompany(@RequestBody CompanyUpdateRequestDto dto){
        return ResponseEntity.ok(companyService.updateCompany(dto));
    }
    @DeleteMapping(DELETE_COMPANY + "/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable String id){
        return ResponseEntity.ok(companyService.deleteCompany(id));
    }

}
