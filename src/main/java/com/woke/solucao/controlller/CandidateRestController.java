package com.woke.solucao.controlller;

import com.woke.solucao.model.Candidate;
import com.woke.solucao.service.CandidateService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class CandidateRestController {

    private final CandidateService candidateService;

    public CandidateRestController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @GetMapping(value = "/api/candidates/company/{id}", produces = "application/json;charset=UTF-8")
    public List<Candidate> getCandidates(@PathVariable Long id){
        return candidateService.finByCompany(id);
    }

    @GetMapping(value = "/api/candidate/{id}", produces = "application/json;charset=UTF-8")
    public Candidate getCandidate(@PathVariable Long id) throws IllegalAccessException {
        return candidateService.getById(id);
    }

    @PutMapping(value = "/api/candidate/save/{companyId}", produces = "application/json;charset=UTF-8")
    public Candidate update(@Valid @RequestBody Candidate candidate, @PathVariable Long companyId){
        return candidateService.saveCandidate(candidate, companyId);
    }
}
