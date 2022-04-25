package com.matbustamant.beportfolio.controllers;

import com.matbustamant.beportfolio.models.Person;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import com.matbustamant.beportfolio.services.PersonService;

@RestController
@CrossOrigin(origins={"http://localhost:4200/"})
@RequestMapping("api/user")
public class PersonController {

         @Autowired
         private PersonService personInterface;

	@PreAuthorize("hasRole('ADMIN')")
         @PostMapping ("/create")
         public Person createUser (@Valid @RequestBody Person user) {
                  return personInterface.savePerson(user);
         }

         @GetMapping ("/read")
         public List<Person> getUsers () {//Cambiar luego a que esto sea solo para uno. (si es que lo limito)
                  return personInterface.getPeople();
         }
         
         @GetMapping ("/read/{id}")
         public Person getUserById (@PathVariable Integer id) {
                  return personInterface.findPersonById(id);
         }

	@PreAuthorize("hasRole('ADMIN')")
         @PutMapping ("/update")
         public Person updateUser (@Valid @RequestBody Person user) {
                  return personInterface.savePerson(user);               
         }

	@PreAuthorize("hasRole('ADMIN')")
         @DeleteMapping ("/delete/{id}")
         public void deleteUser (@PathVariable Integer id) {
                  personInterface.deletePerson(id);
         }

}