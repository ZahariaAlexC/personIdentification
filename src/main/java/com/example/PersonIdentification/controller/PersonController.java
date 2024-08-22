package com.example.PersonIdentification.controller;

import com.example.PersonIdentification.repository.person.Person;
import com.example.PersonIdentification.repository.person.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PersonController {
    @Autowired
    PersonRepo person;

    //adaugam un noua persoana
    @PostMapping("/person")
    @ResponseBody
    public String addNewTodo(@RequestBody Person personCreate){
        person.save(personCreate);
        return "ok";
    }

    //citim lista de persoane
    @GetMapping("/persons")
    @ResponseBody
    public Iterable<Person> getTodos(){
        return person.findAll();
    }

    @PutMapping("/person/{id}")
    @ResponseBody
    public Person updatePerson(@RequestBody Person personUpdate, @PathVariable("id") int id ){
        Person person2 = person.findById(id).get();
        person2.setLastName(personUpdate.getLastName());
        person.save(person2);
        return person2;
    }

    @DeleteMapping("/person/{id}")
    @ResponseBody
    public String deletePerson(@PathVariable("id") int id){
        Person person1 = new Person();
        person1.setId(id);
        this.person.delete(person1);
        return "deleted";
    }

    @GetMapping("/person/{id}/address")
    @ResponseBody
    public String getAddressForPersonId(@PathVariable("id") int id){
        Person person4 = person.findById(id).get();
        return person4.getAddress().getAddressName();
    }
}
