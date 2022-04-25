package com.matbustamant.beportfolio.services;

import com.matbustamant.beportfolio.models.Person;
import java.util.List;

public interface PersonService {

         //método para traer todas las personas
         public List<Person> getPeople ();

         //método para dar de alta una persona
         public Person savePerson(Person person);

         //método para borrar una persona
         public void deletePerson(Integer id);

         //método para encontrar una persona
         public Person findPersonById(Integer id);

}
