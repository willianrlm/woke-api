package com.woke.solucao.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
public class Candidate {
    @Id
    @SequenceGenerator(name = "candidate_seq", sequenceName = "candidate_seq", allocationSize = 1)
    @GeneratedValue(generator = "candidate_seq", strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotBlank
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dateApplication;

    @Enumerated(EnumType.STRING)
    @NotBlank
    private OpinionType opinion = OpinionType.NEUTRAL;

    @ManyToOne
    private User user;

    @JsonIgnore
    @ManyToOne
    private Company company;

    public Candidate() {
    }

    public Candidate(Date dateApplication, OpinionType opinion, User user, Company company) {
        this.dateApplication = dateApplication;
        this.opinion = opinion;
        this.user = user;
        this.company = company;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateApplication() {
        return dateApplication;
    }

    public void setDateApplication(Date dateApplication) {
        this.dateApplication = dateApplication;
    }

    public OpinionType getOpinion() {
        return opinion;
    }

    public void setOpinion(OpinionType opinion) {
        this.opinion = opinion;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public enum OpinionType {
        POSITIVE("POSITIVE"),
        NEGATIVE("NEGATIVE"),
        NEUTRAL("NEUTRAL");

        private final String name;

        OpinionType(String name) {
            this.name = name;
        }
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "id=" + id +
                ", dateApplication=" + dateApplication +
                ", opinion=" + opinion +
                ", user=" + user.getLogin() +
                ", company=" + (company != null ? company.getId() : "null") +
                '}';
    }
}
