package com.matbustamant.beportfolio.services;

import com.matbustamant.beportfolio.models.Person;
import java.util.List;
import org.springframework.stereotype.Service;
import com.matbustamant.beportfolio.repositories.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PersonServiceImp implements PersonService {

         private final PersonRepository personRepo;

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
			throw new IllegalStateException(String.format("La persona con id %d no existe.", id));
		}
                  personRepo.deleteById(id);
         }

         @Override
         public Person findPersonById(Integer id) {
                  return personRepo.findById(id).orElse(null);
         }
}
