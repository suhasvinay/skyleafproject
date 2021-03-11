package com.jspiders.skyproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.skyproject.beans.Card;
import com.jspiders.skyproject.repository.CardRepository;

@RestController
@RequestMapping("/paymen")
public class CardController 
{
	@Autowired
	private CardRepository repository;
	
	@GetMapping("/readAll")
	public Iterable<Card> readAll()
	{
		Iterable<Card> all=repository.findAll();
		return all;
	}
}
