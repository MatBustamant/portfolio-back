package com.matbustamant.beportfolio.services;

import com.matbustamant.beportfolio.models.Person;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.matbustamant.beportfolio.repositories.PersonRepository;

@Service
public class PersonServiceImp implements PersonService {

         @Autowired
         private PersonRepository personRepo;

         @Override
         public List<Person> getPeople() {
                  return personRepo.findAll();
         }

         @Override
         public Person savePerson(Person user) {
                  return personRepo.save(user);
         }

         @Override
         public void deletePerson(Integer id) {
		boolean exists = personRepo.existsById(id);
		if (!exists) {
			throw new IllegalStateException("La persona con id " + id + " no existe.");
		}
                  personRepo.deleteById(id);
         }

         @Override
         public Person findPersonById(Integer id) {
                  return personRepo.findById(id).orElse(null);
         }
}
