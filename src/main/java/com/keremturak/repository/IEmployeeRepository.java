package com.keremturak.repository;

import com.keremturak.repository.entity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmployeeRepository extends MongoRepository<Employee, String> {
    List<Employee> findAllByCompanyId(String companyId);


}
