package com.app.company;

import java.util.List;

public interface CompanyService {

    List<Company> getAllCompanies();

    Company getCompanyById(Long id);

    Company createCompany(Company company);

    Boolean updateCompany(Long id, Company company);

    Boolean deleteCompany(Long id);




}
