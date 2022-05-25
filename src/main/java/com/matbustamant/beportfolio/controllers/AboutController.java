package com.matbustamant.beportfolio.controllers;

import com.matbustamant.beportfolio.models.About;
import com.matbustamant.beportfolio.services.AboutService;
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
@RequestMapping("api/portfolio/about")
@RequiredArgsConstructor
public class AboutController {
	
	private final AboutService aboutInterface;
	
         @PostMapping ("/create")
         public About createAbout (@Valid @RequestBody About about) {
                  return aboutInterface.saveAbout(about);
         }
         
         @GetMapping ("/read/{id}")
         public About getAboutById (@PathVariable Integer id) {
                  return aboutInterface.findAboutById(id);
         }

         @PutMapping ("/update")
         public About updateAbout (@Valid @RequestBody About about) {
                  return aboutInterface.saveAbout(about);
         }

         @DeleteMapping ("/delete/{id}")
         public void deleteAbout (@PathVariable Integer id) {
                  aboutInterface.deleteAbout(id);
         }
	
}
