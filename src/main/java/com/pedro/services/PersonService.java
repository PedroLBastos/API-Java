package com.pedro.services;

import com.pedro.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public List<Person> findAll(){
        List<Person> persons  = new ArrayList<>();
        for (int i = 0; i<8; i++){
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

    private Person mockPerson(int i) {

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirtName("Person name" + i);
        person.setLastName("Last name"+ i);
        person.setAdress("Brasil" + i);
        person.setGender("Male");

        return person;
    }

    public Person findById(String id){

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirtName("Pedro");
        person.setLastName("Bastos");
        person.setAdress("BH");
        person.setGender("Male");

        return person;
    }

    public Person create(Person person){
        return person;
    }

    public Person update(Person person){
        return person;
    }

    public void delete(String id){

    }


}
