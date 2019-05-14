package com.adaming.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adaming.entities.Document;
import com.adaming.service.interfaces.IDocumentService;

@Service
@Transactional
public class DocumentService  extends ServiceGenericImpl<Document> implements IDocumentService{

}
