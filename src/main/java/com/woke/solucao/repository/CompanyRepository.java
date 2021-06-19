package com.woke.solucao.repository;

import com.woke.solucao.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    public List<Company> getAllByCandidatesUserLogin(String login);
}
