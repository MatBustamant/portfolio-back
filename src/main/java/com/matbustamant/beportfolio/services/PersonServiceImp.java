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
         public boolean deletePerson(Integer id) {
		if (!personRepo.existsById(id)) {
			return false;
		}
                  personRepo.deleteById(id);
		return true;
         }

         @Override
         public Person findPersonById(Integer id) {
                  return personRepo.findById(id).orElse(null);
         }
}
