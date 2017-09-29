package com.vadymusyk.code_example.service.company.impl;

import com.vadymusyk.code_example.entity.company.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

/**
 * Created by vadymusyk on 15.08.17.
 */
@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public List<Company> getCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company getCompanyByOwnerId(long id) {
        return companyRepository.findByOwnerId(id)
                .orElseThrow(() -> new EntityNotFoundException("user with id " + id + " has no company"));
    }

    @Override
    public Company addNewCompany(Company build) {
        return companyRepository.save(build);
    }
}
