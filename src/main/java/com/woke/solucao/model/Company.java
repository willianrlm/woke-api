package com.woke.solucao.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Getter @Setter
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
