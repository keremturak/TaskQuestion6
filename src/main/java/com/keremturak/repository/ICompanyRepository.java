package com.keremturak.repository;

import com.keremturak.repository.entity.Company;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICompanyRepository extends MongoRepository<Company, String> {
}
