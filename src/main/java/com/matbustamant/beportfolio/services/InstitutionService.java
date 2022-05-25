package com.matbustamant.beportfolio.services;

import com.matbustamant.beportfolio.models.Institution;
import java.util.List;

public interface InstitutionService {
	
         public List<Institution> getInstitutions();

         public Institution saveInstitution(Institution institution);

         public void deleteInstitution(Integer id);

         public Institution findInstitutionById(Integer id);

}
