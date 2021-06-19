package com.woke.solucao.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ContactType getType() {
        return type;
    }

    public void setType(ContactType type) {
        this.type = type;
    }

    public enum ContactType {
        PHONE ("Phone"),
        EMAIL ("Email");

        private final String name;

        ContactType(String name){
            this.name = name;
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
