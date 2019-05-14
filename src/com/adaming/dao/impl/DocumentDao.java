package com.adaming.dao.impl;

import org.springframework.stereotype.Repository;

import com.adaming.dao.interfaces.IDocumentDao;
import com.adaming.entities.Document;

@Repository
public class DocumentDao extends DaoGenericImpl<Document> implements IDocumentDao{

}
