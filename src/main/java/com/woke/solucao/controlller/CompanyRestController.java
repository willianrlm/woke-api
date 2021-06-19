package com.woke.solucao.controlller;

import com.woke.solucao.model.Company;
import com.woke.solucao.service.CompanyService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class CompanyRestController {
    private final CompanyService companyService;

    public CompanyRestController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping(value = "/api/companies/{login}", produces = "application/json;charset=UTF-8")
    public List<Company> getCompanies(@PathVariable String login){
        return companyService.getAllByUser(login);
    }

    @GetMapping(value = "/api/company/{id}", produces = "application/json;charset=UTF-8")
    public Optional<Company> getCompany(@PathVariable Long id){
        return companyService.getById(id);
    }
}
