package com.app.company.impl;

import com.app.company.Company;
import com.app.company.CompanyRepository;
import com.app.company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

//    Get all companies
    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

//    Get Company by Id
    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id)
                .orElse(null);

    }
//    Create New-Company
    @Override
    public Company createCompany(Company company) {
        return companyRepository.save(company);
    }

//    Update Company By Id
    @Override
    public Boolean updateCompany(Long id, Company company) {
        Optional<Company> company1 = companyRepository.findById(id);
        if (company1.isPresent()) {
            Company company2 = company1.get();
            company2.setCompanyName(company.getCompanyName());
            company2.setDescription(company.getDescription());
            company2.setJobs(company.getJobs());
            companyRepository.save(company2);
            return true;
        }
        return false;
    }

//    Delete Company by Id
    @Override
    public Boolean deleteCompany(Long id) {
        try {
            companyRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
