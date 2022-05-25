package com.matbustamant.beportfolio.controllers;

import com.matbustamant.beportfolio.models.Institution;
import com.matbustamant.beportfolio.services.InstitutionService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/portfolio/institution")
@RequiredArgsConstructor
public class InstitutionController {
	
         private final InstitutionService institutionInterface;

         @PostMapping ("/create")
         public Institution createInstitution (@Valid @RequestBody Institution institution) {
                  return institutionInterface.saveInstitution(institution);
         }

         @GetMapping ("/read")
         public List<Institution> getInstitutions () {
                  return institutionInterface.getInstitutions();
         }
         
         @GetMapping ("/read/{id}")
         public Institution getInstitutionById (@PathVariable Integer id) {
                  return institutionInterface.findInstitutionById(id);
         }

         @PutMapping ("/update")
         public Institution updateInstitution (@Valid @RequestBody Institution institution) {
                  return institutionInterface.saveInstitution(institution);               
         }

         @DeleteMapping ("/delete/{id}")
         public void deleteInstitution (@PathVariable Integer id) {
                  institutionInterface.deleteInstitution(id);
         }
}
