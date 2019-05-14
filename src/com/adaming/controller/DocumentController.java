package com.adaming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adaming.entities.Document;
import com.adaming.service.interfaces.IDocumentService;
@RestController
public class DocumentController {
	@Autowired
	IDocumentService documentService;
	
	@RequestMapping(value = "documents", method = RequestMethod.GET)
	
	public List<Document> findAll(Class<Document> document) {
		return documentService.find(Document.class);
	}
	
	@RequestMapping(value = "documents/{id}", method = RequestMethod.GET)
	public Document findOne(@PathVariable("id") Long id) {
		return documentService.getById(Document.class,id);
	}

	@RequestMapping(value = "documents", method = RequestMethod.POST)
	public Document saveDocument(@RequestBody Document document) {
	
		 documentService.create(document);
		return document;
	}

	@RequestMapping(value = "documents/{id}", method = RequestMethod.DELETE)
	public void deleteDocument(@PathVariable("id") Long id) {
		Document obj= documentService.getById(Document.class,id);
		documentService.delete(obj);
	}

	@RequestMapping(value = "documents/{id}", method = RequestMethod.PUT)
	public Document updateDocument(@PathVariable("id") Long id, @RequestBody Document document) {
		Document currentDocument = documentService.getById(Document.class,id);
		currentDocument.setDateCreation(document.getDateCreation());
		currentDocument.setNom(document.getNom());
		currentDocument.setDescription(document.getDescription());
		
		documentService.create(currentDocument);
		return currentDocument;
	}
}




