package com.woke.solucao.repository;

import com.woke.solucao.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {

    @Query("FROM Candidate c WHERE c.company.id = :id AND c.opinion = :like")
    List<Candidate> findByCompanyLike(@Param("id") Long id, @Param("like") Candidate.OpinionType like);
}
