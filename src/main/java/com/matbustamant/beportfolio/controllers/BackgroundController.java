package com.matbustamant.beportfolio.controllers;

import com.matbustamant.beportfolio.models.Background;
import com.matbustamant.beportfolio.models.BackgroundType;
import com.matbustamant.beportfolio.services.BackgroundService;
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
@RequestMapping("api/portfolio/background")
@RequiredArgsConstructor
public class BackgroundController {
	
	private final BackgroundService bgInterface;
	
         @PostMapping ("/create")
         public Background createBackground (@Valid @RequestBody Background background) {
                  return bgInterface.saveBackground(background);
         }

         @GetMapping ("/read/bt{bgtype}")
         public List<Background> getBackgroundsByType (@PathVariable BackgroundType bgtype) {
                  return bgInterface.getBackgroundsByType(bgtype);
         }
         
         @GetMapping ("/read/{id}")
         public Background getBackgroundById (@PathVariable Integer id) {
                  return bgInterface.findBackgroundById(id);
         }

         @PutMapping ("/update")
         public Background updateBackground (@Valid @RequestBody Background background) {
                  return bgInterface.saveBackground(background);
         }

         @DeleteMapping ("/delete/{id}")
         public void deleteBackground (@PathVariable Integer id) {
                  bgInterface.deleteBackground(id);
         }

}
