package com.adaming.utils;

import java.util.List;

import com.adaming.entities.Affaire;

public interface ServiceGeneric  <T> {

	public Affaire create(T obj);
	
	public void update(T obj);
	
	public void delete (Long id);
	
	public T getById(Class<T> obj, Long id);
	
	public List<T> find(Long id);

}
