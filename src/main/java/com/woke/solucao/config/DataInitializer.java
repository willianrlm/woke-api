package com.woke.solucao.config;

import com.woke.solucao.model.*;
import com.woke.solucao.repository.CandidateRepository;
import com.woke.solucao.repository.CompanyRepository;
import com.woke.solucao.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Component
public class DataInitializer implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    PersonRepository personRepository;
    @Autowired
    CompanyRepository companyRepository;
    @Autowired
    CandidateRepository candidateRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        List<Person> people = personRepository.findAll();

        if(people.isEmpty()){

            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

            try {

                Person p1  = new Person("Willian da Rocha Lopes Manucello", formatter.parse("18/11/1994"),
                        "willianrlm", "$2a$10$fCgCbzfVXsI.6Zq3gdWaUOuW4Yjj9uVd.LNGCPd1MjNZQLPNDvm9G",
                        new Contact("55996984336", Contact.ContactType.PHONE));
                p1.getContacts().add(new Contact("willianrlm@gmail.com", Contact.ContactType.EMAIL));
                people.add(p1);

                people.add(new Person("Fulano", formatter.parse("18/11/1992"),"fulano", "1234", new Contact("55996984336", Contact.ContactType.PHONE)));
                people.add(new Person("Ciclano", formatter.parse("18/11/1993"),"ciclano", "43212", new Contact("55996984336", Contact.ContactType.PHONE)));
                people.add(new Person("Deutrano", formatter.parse("18/11/1991"),"deutrano", "$*&¨%#&#", new Contact("55996984336", Contact.ContactType.PHONE)));
                people.add(new Person("Outrano", formatter.parse("18/11/1964"),"outrano", "a1b2c3", new Contact("55996984336", Contact.ContactType.PHONE)));
                people.add(new Person("Ultimano", formatter.parse("18/11/1974"),"thelastone", "senha", new Contact("55996984336", Contact.ContactType.PHONE)));

            } catch (ParseException e) {
                e.printStackTrace();
            }

            personRepository.saveAll(people);
        }

        List<Company> companies = companyRepository.findAll();

        if(companies.isEmpty()){
            companies.add(new Company("Google", "das buscas", new User("google", "$2a$10$fCgCbzfVXsI.6Zq3gdWaUOuW4Yjj9uVd.LNGCPd1MjNZQLPNDvm9G")));
            companies.add(new Company("Amazon", "dos servidores"));
            companies.add(new Company("Facebook", "das redes"));
            companies.add(new Company("Microsoft", "dos windows"));
            companies.add(new Company("Apple", "das coisas caras"));

            companyRepository.saveAll(companies);
        }

        List<Candidate> candidates = candidateRepository.findAll();

        if(candidates.isEmpty()){
            candidates.add(new Candidate(new Date(), Candidate.OpinionType.POSITIVE, people.get(0).getUsers().iterator().next(), companies.get(0)));
            candidates.add(new Candidate(new Date(), Candidate.OpinionType.POSITIVE, people.get(1).getUsers().iterator().next(), companies.get(0)));
            candidates.add(new Candidate(new Date(), Candidate.OpinionType.POSITIVE, people.get(2).getUsers().iterator().next(), companies.get(0)));
            candidates.add(new Candidate(new Date(), Candidate.OpinionType.POSITIVE, people.get(3).getUsers().iterator().next(), companies.get(0)));
            candidates.add(new Candidate(new Date(), Candidate.OpinionType.NEGATIVE, people.get(4).getUsers().iterator().next(), companies.get(1)));
            candidates.add(new Candidate(new Date(), Candidate.OpinionType.NEUTRAL, people.get(5).getUsers().iterator().next(), companies.get(3)));

            candidateRepository.saveAll(candidates);
        }
    }
}
