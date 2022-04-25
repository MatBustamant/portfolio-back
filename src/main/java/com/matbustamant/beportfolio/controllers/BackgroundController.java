package com.matbustamant.beportfolio.controllers;

import com.matbustamant.beportfolio.models.Background;
import com.matbustamant.beportfolio.models.BackgroundType;
import com.matbustamant.beportfolio.services.BackgroundService;
import java.util.List;
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
@RequestMapping("api/background")
public class BackgroundController {
	
	@Autowired
	private BackgroundService bgInterface;
	
	@PreAuthorize("hasRole('ADMIN')")
         @PostMapping ("/create")
         public Background createBackground (@Valid @RequestBody Background background) {
                  return bgInterface.saveBackground(background);
         }

         @GetMapping ("/read")
         public List<Background> getBackgrounds (BackgroundType bgtype) {
                  return bgInterface.getBackgroundsByType(bgtype);
         }
         
         @GetMapping ("/read/{id}")
         public Background getExperienceById (@PathVariable Integer id) {
                  return bgInterface.findBackgroundById(id);
         }

	@PreAuthorize("hasRole('ADMIN')")
         @PutMapping ("/update")
         public Background updateBackground (@Valid @RequestBody Background background) {
                  return bgInterface.saveBackground(background);               
         }

	@PreAuthorize("hasRole('ADMIN')")
         @DeleteMapping ("/delete/{id}")
         public void deleteBackground (@PathVariable Integer id) {
                  bgInterface.deleteBackground(id);
         }

}
