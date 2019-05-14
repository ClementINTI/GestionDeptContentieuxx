package com.adaming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adaming.entities.Tribunal;
import com.adaming.service.interfaces.ITribunalService;

@RestController
public class TribunalController {
	@Autowired
	ITribunalService tribunalService;
	
	@RequestMapping(value = "tribunal", method = RequestMethod.GET)
	
	public List<Tribunal> findAll(Class<Tribunal> tribunal) {
		return tribunalService.find(Tribunal.class);
	}
	
	@RequestMapping(value = "tribunal/{id}", method = RequestMethod.GET)
	public Tribunal findOne(@PathVariable("id") Long id) {
		return tribunalService.getById(Tribunal.class,id);
	}

	@RequestMapping(value = "tribunal", method = RequestMethod.POST)
	public Tribunal saveTribunal(@RequestBody Tribunal tribunal) {
	
		 tribunalService.create(tribunal);
		return tribunal;
	}

	@RequestMapping(value = "tribunal/{id}", method = RequestMethod.DELETE)
	public void deleteTribunal(@PathVariable("id") Long id) {
		Tribunal obj= tribunalService.getById(Tribunal.class,id);
		tribunalService.delete(obj);
	}

	@RequestMapping(value = "tribunal/{id}", method = RequestMethod.PUT)
	public Tribunal updateTribunal(@PathVariable("id") Long id, @RequestBody Tribunal tribunal) {
		Tribunal currentTribunal = tribunalService.getById(Tribunal.class,id);
		currentTribunal.setAdresse(tribunal.getAdresse());
		currentTribunal.setFax(tribunal.getFax());
		currentTribunal.setTel(tribunal.getTel());
		currentTribunal.setRegion(tribunal.getRegion());
		
		tribunalService.create(currentTribunal);
		return currentTribunal;
	}
}






