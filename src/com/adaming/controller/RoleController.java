package com.adaming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adaming.entities.Role;
import com.adaming.service.interfaces.IRoleService;

@RestController
public class RoleController {
	@Autowired
	IRoleService roleService;
	
	@RequestMapping(value = "roles", method = RequestMethod.GET)
	
	public List<Role> findAll(Class<Role> role) {
		return roleService.find(Role.class);
	}
	
	@RequestMapping(value = "roles/{id}", method = RequestMethod.GET)
	public Role findOne(@PathVariable("id") Long id) {
		return roleService.getById(Role.class,id);
	}

	@RequestMapping(value = "roles", method = RequestMethod.POST)
	public Role saveRole(@RequestBody Role role) {
	
		 roleService.create(role);
		return role;
	}

	@RequestMapping(value = "roles/{id}", method = RequestMethod.DELETE)
	public void deleteRole(@PathVariable("id") Long id) {
		Role obj= roleService.getById(Role.class,id);
		roleService.delete(obj);
	}

	@RequestMapping(value = "roles/{id}", method = RequestMethod.PUT)
	public Role updateRole(@PathVariable("id") Long id, @RequestBody Role role) {
		Role currentRole = roleService.getById(Role.class,id);
		currentRole.setLibelle(role.getLibelle());
		
		
		
		roleService.create(currentRole);
		return currentRole;
	}
}




