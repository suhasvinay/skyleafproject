package com.jspiders.skyproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.skyproject.beans.CardExpiry;
import com.jspiders.skyproject.repository.CardExpiryRepository;

@RestController
@RequestMapping("/payme")
public class CardExpiryController 
{
	@Autowired
	private CardExpiryRepository repository;
	
	@GetMapping("/readAll")
	public Iterable<CardExpiry> readAll()
	{
		Iterable<CardExpiry> all=repository.findAll();
		return all;
	}
}
