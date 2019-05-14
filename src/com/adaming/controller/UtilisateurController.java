package com.adaming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adaming.entities.Utilisateur;
import com.adaming.service.interfaces.IUtilisateurService;

@RestController
public class UtilisateurController {
	@Autowired
	IUtilisateurService utilisateurService;
	
	@RequestMapping(value = "utilisateurs", method = RequestMethod.GET)
	
	public List<Utilisateur> findAll(Class<Utilisateur> utilisateur) {
		return utilisateurService.find(Utilisateur.class);
	}
	
	@RequestMapping(value = "utilisateurs/{id}", method = RequestMethod.GET)
	public Utilisateur findOne(@PathVariable("id") Long id) {
		return utilisateurService.getById(Utilisateur.class,id);
	}

	@RequestMapping(value = "utilisateurs", method = RequestMethod.POST)
	public Utilisateur saveUtilisateur(@RequestBody Utilisateur utilisateur) {
	
		 utilisateurService.create(utilisateur);
		return utilisateur;
	}

	@RequestMapping(value = "utilisateurs/{id}", method = RequestMethod.DELETE)
	public void deleteUtilisateur(@PathVariable("id") Long id) {
		Utilisateur obj= utilisateurService.getById(Utilisateur.class,id);
		utilisateurService.delete(obj);
	}

	@RequestMapping(value = "utilisateurs/{id}", method = RequestMethod.PUT)
	public Utilisateur updateUtilisateur(@PathVariable("id") Long id, @RequestBody Utilisateur utilisateur) {
		Utilisateur currentUtilisateur = utilisateurService.getById(Utilisateur.class,id);
		currentUtilisateur.setEmail(utilisateur.getEmail());
		currentUtilisateur.setNom(utilisateur.getNom());
		currentUtilisateur.setPrenom(utilisateur.getPrenom());
		
		utilisateurService.create(currentUtilisateur);
		return currentUtilisateur;
	}
}







