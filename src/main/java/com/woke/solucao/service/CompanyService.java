package com.woke.solucao.service;

import com.woke.solucao.model.Company;
import java.util.List;
import java.util.Optional;

public interface CompanyService {
    List<Company> getAllByUser(String login);

    Optional<Company> getById(Long id);

}
