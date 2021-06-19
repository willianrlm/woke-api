package com.woke.solucao.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter @Setter
@Entity
public class Contact {
    @Id
    @SequenceGenerator(name = "contact_seq", sequenceName = "contact_seq", allocationSize = 1)
    @GeneratedValue(generator = "contact_seq", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Size(max = 200)
    @NotBlank
    private String value;

    @Enumerated(EnumType.STRING)
    @NotBlank
    private ContactType type;

    public Contact() {
    }

    public Contact(String value, ContactType type) {
        this.value = value;
        this.type = type;
    }

    public enum ContactType {
        PHONE ("PHONE"),
        EMAIL ("EMAIL");

        ContactType(String name){
        }
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", value='" + value + '\'' +
                ", type=" + type +
                '}';
    }
}
