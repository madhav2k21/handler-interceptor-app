package com.techleads.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
	
	@GetMapping(value = {"/messages"})
	public String myMessage() {
		return "Pay the airtel bill";
	}

}
