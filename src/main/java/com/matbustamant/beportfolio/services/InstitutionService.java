package com.matbustamant.beportfolio.services;

import com.matbustamant.beportfolio.models.Institution;
import java.util.List;

public interface InstitutionService {
	
         //método para traer todos los registros
         public List<Institution> getInstitution();

         //método para dar de alta un registro
         public Institution saveInstitution(Institution institution);

         //método para borrar un registro
         public void deleteInstitution(Integer id);

         //método para encontrar un registro
         public Institution findInstitutionById(Integer id);

}
