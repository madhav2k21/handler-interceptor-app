package com.techleads.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.techleads.app.model.Message;
import com.techleads.app.service.MessageService;

@RestController
public class MessageController {

	private MessageService service;

	public MessageController(MessageService service) {
		super();
		this.service = service;
	}

	@GetMapping(value = { "/messages" })
	public String myMessage() {
		return service.myMessage();
	}

	@PostMapping(value = { "/messages" })
	public ResponseEntity<String> saveMsg(@RequestBody Message msg) {
		String result = service.saveMessage(msg);
		if (null != result) {

			return new ResponseEntity<>(result, HttpStatus.CREATED);
		}
		return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
	}

	

}
