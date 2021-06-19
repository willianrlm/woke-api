package com.woke.solucao.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Getter @Setter
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

    public enum OpinionType {
        POSITIVE("POSITIVE"),
        NEGATIVE("NEGATIVE"),
        NEUTRAL("NEUTRAL");

        OpinionType(String name) {
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
