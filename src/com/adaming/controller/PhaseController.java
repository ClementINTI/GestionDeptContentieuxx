package com.adaming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adaming.entities.Phase;
import com.adaming.service.interfaces.IPhaseService;

@RestController
public class PhaseController {
	@Autowired
	IPhaseService phaseService;
	
	@RequestMapping(value = "phases", method = RequestMethod.GET)
	
	public List<Phase> findAll(Class<Phase> phase) {
		return phaseService.find(Phase.class);
	}
	
	@RequestMapping(value = "phases/{id}", method = RequestMethod.GET)
	public Phase findOne(@PathVariable("id") Long id) {
		return phaseService.getById(Phase.class,id);
	}

	@RequestMapping(value = "phases", method = RequestMethod.POST)
	public Phase savePhase(@RequestBody Phase phase) {
	
		 phaseService.create(phase);
		return phase;
	}

	@RequestMapping(value = "phases/{id}", method = RequestMethod.DELETE)
	public void deletePhase(@PathVariable("id") Long id) {
		Phase obj= phaseService.getById(Phase.class,id);
		phaseService.delete(obj);
	}

	@RequestMapping(value = "phases/{id}", method = RequestMethod.PUT)
	public Phase updatePhase(@PathVariable("id") Long id, @RequestBody Phase phase) {
		Phase currentPhase = phaseService.getById(Phase.class,id);
		currentPhase.setNom(phase.getNom());
		currentPhase.setDateDebut(phase.getDateDebut());
		currentPhase.setDateFin(phase.getDateFin());
		
		phaseService.create(currentPhase);
		return currentPhase;
	}
}





