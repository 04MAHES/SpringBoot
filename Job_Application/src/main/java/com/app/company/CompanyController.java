package com.app.company;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompanies() {
        List<Company> companies = companyService.getAllCompanies();
        if(companies != null) {
            return new ResponseEntity<>(companies, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long id) {
        System.out.println("ID: "+ id);
        Company company = companyService.getCompanyById(id);
        if(company != null) {
            return new ResponseEntity<>(company, HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Company> createCompany(@RequestBody Company company) {
        Company company1 = companyService.createCompany(company);
        return new ResponseEntity<>(company1, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable Long id, @RequestBody Company company) {
        boolean status = companyService.updateCompany(id, company);
        if(status) {
            return new ResponseEntity<>("Company Details Updated Successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Company Not Found with Id: "+id, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/id")
    public ResponseEntity<String> deleteCompany(@PathVariable Long id) {
        boolean status = companyService.deleteCompany(id);
        if(status) {
            return new ResponseEntity<>("Company Deleted Successful with id: "+id, HttpStatus.OK);
        }
        return new ResponseEntity<>("Company Not Found with id: "+id, HttpStatus.NOT_FOUND);
    }

}
