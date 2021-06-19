package com.woke.solucao.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Company {
    @Id
    @SequenceGenerator(name = "company_seq", sequenceName = "company_seq", allocationSize = 1)
    @GeneratedValue(generator = "company_seq", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Size(max = 300)
    @NotBlank
    private String name;

    @Size(max = 1000)
    private String description;

    @JsonIgnore
    @OneToMany(targetEntity = Candidate.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "company")
    private Set<Candidate> candidates;

    @JsonIgnore
    @OneToMany(targetEntity = User.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<User> users;

    @Transient
    private Candidate candidate;

    public Company() {
    }

    public Company(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Company(String name, String description, User user) {
        this.name = name;
        this.description = description;
        this.users = new HashSet<>();
        users.add(user);
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Candidate> getCandidates() {
        return candidates;
    }

    public void setCandidates(Set<Candidate> candidates) {
        this.candidates = candidates;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", candidate=" + candidate +
                '}';
    }
}
