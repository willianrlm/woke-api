package com.woke.solucao.service;

import com.woke.solucao.model.Candidate;
import com.woke.solucao.model.Company;
import com.woke.solucao.repository.CandidateRepository;
import com.woke.solucao.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CompanyServiceImpl extends ServiceImpl<Company> implements CompanyService {

    private final CompanyRepository companyRepository;
    private final UserService userService;
    private final CandidateRepository candidateRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository, UserService userService, CandidateRepository candidateRepository) {
        this.companyRepository = companyRepository;
        this.userService = userService;
        this.candidateRepository = candidateRepository;
    }

    @Override
    public List<Company> getAllByUser(String login) {
        List<Company> companies = companyRepository.findAll();

        Set<Candidate> candidates = userService.findByLogin(login).getCandidates();

        companies.forEach(company -> {
            candidates.forEach(candidate -> {
                if(company.equals(candidate.getCompany()))
                    company.setCandidate(candidate);
            });
        });

        return companies;
    }

    @Override
    public Optional<Company> getById(Long id) {
        return companyRepository.findById(id);
    }
}
