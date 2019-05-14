package com.adaming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adaming.entities.Tache;
import com.adaming.service.interfaces.ITacheService;

@RestController
public class TacheController {
	@Autowired
	ITacheService tacheService;
	
	@RequestMapping(value = "taches", method = RequestMethod.GET)
	
	public List<Tache> findAll(Class<Tache> tache) {
		return tacheService.find(Tache.class);
	}
	
	@RequestMapping(value = "taches/{id}", method = RequestMethod.GET)
	public Tache findOne(@PathVariable("id") Long id) {
		return tacheService.getById(Tache.class,id);
	}

	@RequestMapping(value = "taches", method = RequestMethod.POST)
	public Tache saveTache(@RequestBody Tache tache) {
	
		 tacheService.create(tache);
		return tache;
	}

	@RequestMapping(value = "taches/{id}", method = RequestMethod.DELETE)
	public void deleteTache(@PathVariable("id") Long id) {
		Tache obj= tacheService.getById(Tache.class,id);
		tacheService.delete(obj);
	}

	@RequestMapping(value = "taches/{id}", method = RequestMethod.PUT)
	public Tache updateTache(@PathVariable("id") Long id, @RequestBody Tache tache) {
		Tache currentTache = tacheService.getById(Tache.class,id);
		currentTache.setDateCreation(tache.getDateCreation());
		currentTache.setDescription(tache.getDescription());
		currentTache.setTitre(tache.getTitre());
		currentTache.setStatutAudience(tache.isStatutAudience());
		
		tacheService.create(currentTache);
		return currentTache;
	}
}




