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
	
	@RequestMapping(value = "affaires", method = RequestMethod.GET)
	
	public List<Affaire> findAll(Class<Affaire> affaire) {
		return affaireService.find(Affaire.class);
	}
	
	@RequestMapping(value = "affaires/{id}", method = RequestMethod.GET)
	public Affaire findOne(@PathVariable("id") Long id) {
		return affaireService.getById(Affaire.class,id);
	}

	@RequestMapping(value = "affaires", method = RequestMethod.POST)
	public Affaire saveAffaire(@RequestBody Affaire affaire) {
	
		 affaireService.create(affaire);
		return affaire;
	}

	@RequestMapping(value = "affaires/{id}", method = RequestMethod.DELETE)
	public void deleteAffaire(@PathVariable("id") Long id) {
		Affaire obj= affaireService.getById(Affaire.class,id);
		affaireService.delete(obj);
	}

	@RequestMapping(value = "affaires/{id}", method = RequestMethod.PUT)
	public Affaire updateAffaire(@PathVariable("id") Long id, @RequestBody Affaire affaire) {
		Affaire currentAffaire = affaireService.getById(Affaire.class,id);
		currentAffaire.setReference(affaire.getReference());
		currentAffaire.setTitre(affaire.getTitre());
		currentAffaire.setDescription(affaire.getDescription());
		
		affaireService.create(currentAffaire);
		return currentAffaire;
	}
}


