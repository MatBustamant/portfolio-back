package com.matbustamant.beportfolio.controllers;

import com.matbustamant.beportfolio.dtos.Message;
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
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("api/portfolio/person")
@RequiredArgsConstructor
public class PersonController {

         private final PersonService personInterface;

         @PostMapping ("/create")
         public ResponseEntity<?> createPerson (@Valid @RequestBody Person person, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().body(new Message("Error. Campos inválidos."));
         }
         
		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/portfolio/person/create").toUriString());
		
                  return ResponseEntity.created(uri).body(personInterface.savePerson(person));
         }
         
         @GetMapping ("/read/{id}")
         public ResponseEntity<Person> getPersonById (@PathVariable Integer id) {
		Person person = personInterface.findPersonById(id);
		if (person == null) {
			return ResponseEntity.notFound().build();
         }
                  return ResponseEntity.ok().body(person);
	}

         @PutMapping ("/update")
         public ResponseEntity<?> updatePerson (@Valid @RequestBody Person person, BindingResult bindingResult) {
		Person p = personInterface.findPersonById(person.getId());
		if (p != null) {
			if (bindingResult.hasErrors()) {
				return ResponseEntity.badRequest().body(new Message("Error. Campos inválidos."));
         }
			return ResponseEntity.ok().body(personInterface.savePerson(person));
		}
                  return ResponseEntity.notFound().build();
         }

         @DeleteMapping ("/delete/{id}")
         public ResponseEntity deletePerson (@PathVariable Integer id) {
		if (personInterface.deletePerson(id)) {
			return ResponseEntity.ok().build();
         }
                  return ResponseEntity.notFound().build();
         }

}
