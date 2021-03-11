package com.jspiders.skyproject.controller;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.jspiders.skyproject.beans.BillingDetails;
import com.jspiders.skyproject.beans.Card;
import com.jspiders.skyproject.beans.CardExpiry;
import com.jspiders.skyproject.beans.PaymentMethod;
import com.jspiders.skyproject.beans.ReturnLinks;
import com.jspiders.skyproject.repository.BillingDetailsRepository;
import com.jspiders.skyproject.repository.CardExpiryRepository;
import com.jspiders.skyproject.repository.CardRepository;
import com.jspiders.skyproject.repository.PaymentMethodRepository;
import com.jspiders.skyproject.repository.ReturnLinksRepository;

@RestController
@RequestMapping("/leaf")
public class PaymentMethodController {
	@Autowired
	private PaymentMethodRepository repository;
	
	@Autowired
	private BillingDetailsRepository billrepository;
	
	@Autowired
	private CardRepository cardrepository;
	
	@Autowired
	private CardExpiryRepository cardexpiryrepository;
	
	@Autowired
	private ReturnLinksRepository returnlinksrepository;
	
	@GetMapping("/readAll")
	public String readAll()
	{
		Iterable<PaymentMethod> all=repository.findAll();
		Gson gson = new Gson();
		String json = gson.toJson(all);
		
		JSONArray j1 = new JSONArray(json);
		JSONObject res = new JSONObject(j1.get(0).toString());
		
		Iterable<BillingDetails> billingresponse = billrepository.findAll();
		
		json = gson.toJson(billingresponse);
		JSONObject billingJson = new JSONObject(new JSONArray(json).get(0).toString());
		res.put("BillingDetails",billingJson);
		
		Iterable<Card> cardResponse  = cardrepository.findAll();
		
		json = gson.toJson(cardResponse);
		JSONObject cardJson = new JSONObject(new JSONArray(json).get(0).toString());
		
		Iterable<CardExpiry> cardexpiry = cardexpiryrepository.findAll();
		
		json = gson.toJson(cardexpiry);
		JSONObject cardExpiryJson = new JSONObject(new JSONArray(json).get(0).toString());
		cardJson.put("cardExpiry",cardExpiryJson);
		
		res.put("card",cardJson);
		
		Iterable<ReturnLinks> returnLink = returnlinksrepository.findAll();
		
		json = gson.toJson(returnLink);
//		JSONObject returnlinkJson = new JSONObject(new JSONArray(json).get(0).toString());
		
		res.put("returnlinks",new JSONArray(json));
		return res.toString();
		
	}
}
