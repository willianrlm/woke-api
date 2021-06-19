package com.woke.solucao.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter @Setter
@Entity
public class Person {
    @Id
    @SequenceGenerator(name = "person_seq", sequenceName = "person_seq", allocationSize = 1)
    @GeneratedValue(generator = "person_seq", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Size(max = 300)
    @NotBlank
    private String name;

    @NonNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date birthday;

    @JsonIgnore
    @OneToMany(targetEntity = User.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "person")
    private Set<User> users;

    @OneToMany(targetEntity = Contact.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Contact> contacts;

    public Person() {
    }

    public Person(String name, Date birthday, String login, String password, Contact contact) {
        this.name = name;
        this.birthday = birthday;
        this.users = new HashSet<>();
        this.users.add(new User(login, password, this));
        this.contacts = new HashSet<>();
        this.contacts.add(contact);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", contacts=" + contacts +
                '}';
    }
}
