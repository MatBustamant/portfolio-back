package com.matbustamant.beportfolio.controllers;

import com.matbustamant.beportfolio.models.About;
import com.matbustamant.beportfolio.services.AboutService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins={"http://localhost:4200/"})
@RequestMapping("api/about")
public class AboutController {
	
	@Autowired
	private AboutService aboutInterface;
	
	@PreAuthorize("hasRole('ADMIN')")
         @PostMapping ("/create")
         public About createAbout (@Valid @RequestBody About about) {
                  return aboutInterface.saveAbout(about);
         }
         
         @GetMapping ("/read/{id}")
         public About getAboutById (@PathVariable Integer id) {
                  return aboutInterface.findAboutById(id);
         }

	@PreAuthorize("hasRole('ADMIN')")
         @PutMapping ("/update")
         public About updateAbout (@Valid @RequestBody About about) {
                  return aboutInterface.saveAbout(about);
         }

	@PreAuthorize("hasRole('ADMIN')")
         @DeleteMapping ("/delete/{id}")
         public void deleteAbout (@PathVariable Integer id) {
                  aboutInterface.deleteAbout(id);
         }
	
}
