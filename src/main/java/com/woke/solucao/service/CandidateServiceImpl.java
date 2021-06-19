package com.woke.solucao.service;

import com.woke.solucao.model.Candidate;
import com.woke.solucao.model.Company;
import com.woke.solucao.model.Person;
import com.woke.solucao.model.User;
import com.woke.solucao.repository.CandidateRepository;
import com.woke.solucao.repository.CompanyRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CandidateServiceImpl extends ServiceImpl<Candidate> implements CandidateService {

    private final CandidateRepository candidateRepository;
    private final CompanyRepository companyRepository;

    private static final String userFailAuth = "Id passado por parâmetro não corresponde ao usuário logado";

    public List<Candidate> finByCompany(Long id) {
        validateUserCompany(id);

        List<Candidate> candidates = candidateRepository.findByCompanyLike(id, Candidate.OpinionType.POSITIVE);

        candidates.forEach(candidate -> {
            Person person = candidate.getUser().getPerson();
            candidate.setUser(new User());
            candidate.getUser().setPerson(person);
        });

        return candidates;
    }

    @Override
    public List<Candidate> findAll() {
        return candidateRepository.findAll();
    }

    @Override
    public Candidate getById(Long id) throws IllegalAccessException {
        Candidate candidate = candidateRepository.findById(id).get();

        if(!candidate.getOpinion().equals(Candidate.OpinionType.POSITIVE)){
            throw new IllegalAccessException("Destino não condiz com as credênciais.");
        }

        validateUserCompany(candidate.getCompany().getId());

        Person person = candidate.getUser().getPerson();
        candidate.setUser(new User());
        candidate.getUser().setPerson(person);
        candidate.setCompany(null);

        return candidate;
    }

    @Override
    public Candidate saveCandidate(Candidate candidate, Long companyId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        if(!candidate.getUser().getLogin().equals(currentPrincipalName)){
            throw new SecurityException(userFailAuth);
        }

        if (companyId > 0) {
            candidate.setCompany(companyRepository.getById(companyId));
        }
        return candidateRepository.save(candidate);
    }

    private void validateUserCompany(Long idCompany){
        Company company = companyRepository.getById(idCompany);
        if(company.getUsers().isEmpty()){
            throw new SecurityException(userFailAuth);
        }else{
            company.getUsers().forEach(user -> {
                Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
                String currentPrincipalName = authentication.getName();
                if(!user.getLogin().equals(currentPrincipalName)){
                    throw new SecurityException(userFailAuth);
                }
            });
        }
    }
}
