package com.matbustamant.beportfolio.services;

import com.matbustamant.beportfolio.models.Person;
import java.util.List;

public interface PersonService {

         public List<Person> getPeople ();

         public Person savePerson(Person person);

         public boolean deletePerson(Integer id);

         public Person findPersonById(Integer id);

}
