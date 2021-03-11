package com.jspiders.skyproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.skyproject.beans.ReturnLinks;
import com.jspiders.skyproject.repository.ReturnLinksRepository;

@RestController
@RequestMapping("/payment")
public class ReturnLinksController 
{
	@Autowired
	private ReturnLinksRepository repository;
	
	@GetMapping("/readAll")
	public Iterable<ReturnLinks> readAll()
	{
		Iterable<ReturnLinks> all=repository.findAll();
		return all;
	}
}
