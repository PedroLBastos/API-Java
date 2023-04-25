package com.pedro.controller;

import com.pedro.model.Person;
import com.pedro.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService service;

    @GetMapping("/{id}")
    public Person findById(@PathVariable(value = "id") String id) {
        return service.findById(id);
    }

    @GetMapping()
    public List<Person> findyAll() {
        return service.findAll();
    }

    @PostMapping()
    public Person create(@RequestBody Person person) {
        return service.create(person);
    }

    @PutMapping ( )
    public Person update(@RequestBody Person person) {
        return service.update(person);
    }

    @DeleteMapping("/{id}")
    public void delte(@PathVariable(value = "id") String id) {
        service.delete(id);
    }



}
