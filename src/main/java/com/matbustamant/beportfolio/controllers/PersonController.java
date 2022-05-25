package com.matbustamant.beportfolio.controllers;

import com.matbustamant.beportfolio.models.Person;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.RequestMapping;
import com.matbustamant.beportfolio.services.PersonService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/portfolio/person")
@RequiredArgsConstructor
public class PersonController {

         private final PersonService personInterface;

         @PostMapping ("/create")
         public Person createPerson (@Valid @RequestBody Person person) {
                  return personInterface.savePerson(person);
         }
         
         @GetMapping ("/read/{id}")
         public Person getPersonById (@PathVariable Integer id) {
                  return personInterface.findPersonById(id);
         }

         @PutMapping ("/update")
         public Person updatePerson (@Valid @RequestBody Person person) {
                  return personInterface.savePerson(person);               
         }

         @DeleteMapping ("/delete/{id}")
         public void deletePerson (@PathVariable Integer id) {
                  personInterface.deletePerson(id);
         }

}
