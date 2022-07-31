package com.matbustamant.beportfolio.controllers;

import com.matbustamant.beportfolio.dtos.Message;
import com.matbustamant.beportfolio.models.Background;
import com.matbustamant.beportfolio.services.BackgroundService;
import java.net.URI;
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
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("api/portfolio/background")
@RequiredArgsConstructor
public class BackgroundController {
	
	private final BackgroundService bgInterface;
	
	@PostMapping("/create")
	public ResponseEntity<?> createBackground(@Valid @RequestBody Background background, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().body(new Message("Error. Campos inválidos."));
         }

		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/portfolio/background/create").toUriString());

		return ResponseEntity.created(uri).body(bgInterface.saveBackground(background));
         }
         
	@GetMapping("/read/bt{id}")
	public ResponseEntity<List<Background>> getBackgroundsByType(@PathVariable Short id) {
		List<Background> lista = bgInterface.getBackgroundsByType(id);
		if (lista == null) {
			return ResponseEntity.notFound().build();
         }
		return ResponseEntity.ok().body(lista);
	}

	@GetMapping("/read/{id}")
	public ResponseEntity<Background> getBackgroundById(@PathVariable Integer id) {
		Background background = bgInterface.findBackgroundById(id);
		if (background == null) {
			return ResponseEntity.notFound().build();
         }
		return ResponseEntity.ok().body(background);
	}

	@PutMapping("/update")
	public ResponseEntity<?> updateBackground(@Valid @RequestBody Background background, BindingResult bindingResult) {
		Background bg = bgInterface.findBackgroundById(background.getId());
		if (bg != null) {
			if (bindingResult.hasErrors()) {
				return ResponseEntity.badRequest().body(new Message("Error. Campos inválidos."));
         }
			return ResponseEntity.ok().body(bgInterface.saveBackground(background));
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity deleteBackground(@PathVariable Integer id) {
		if (bgInterface.deleteBackground(id)) {
			return ResponseEntity.ok().build();
}
		return ResponseEntity.notFound().build();
	}

}
