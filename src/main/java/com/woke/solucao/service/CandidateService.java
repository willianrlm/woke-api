package com.woke.solucao.service;

import com.woke.solucao.model.Candidate;

import java.util.List;

public interface CandidateService {
    List<Candidate> findAll();

    List<Candidate> finByCompany(Long id);

    Candidate getById(Long id) throws IllegalAccessException;

    Candidate saveCandidate(Candidate candidate, Long companyId);
}
