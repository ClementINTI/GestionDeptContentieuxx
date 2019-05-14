package com.adaming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adaming.entities.Affaire;
import com.adaming.service.interfaces.IAffaireService;

@RestController
	public class AffaireController {
		@Autowired
		IAffaireService affaireService;
		
		@RequestMapping(value = "users", method = RequestMethod.GET)
		
		public List<Affaire> findAll() {
			return affaireService.findAll();
		}
		
		@RequestMapping(value = "users/{id}", method = RequestMethod.GET)
		public Affaire findOne(@PathVariable("id") Long id) {
			return affaireService.find(id);
		}

		@RequestMapping(value = "users", method = RequestMethod.POST)
		public Affaire saveAffaire(@RequestBody Affaire affaire) {
		
			return affaireService.create(affaire);
		}

		@RequestMapping(value = "users/{id}", method = RequestMethod.DELETE)
		public void deleteAffaire(@PathVariable("id") Long id) {
			affaireService.delete(id);
		}

		@RequestMapping(value = "users/{id}", method = RequestMethod.PUT)
		public Affaire updateAffaire(@PathVariable("id") Long id, @RequestBody Affaire affaire) {
			Affaire currentUser = affaireService.find(id);
			currentUser.setReference(affaire.getReference());
			currentUser.setTitre(affaire.getTitre());
			currentUser.setDescription(affaire.getDescription());
			currentUser.setStatus(affaire.getStatus());
			return affaireService.save(currentUser);
		}
	}


}
