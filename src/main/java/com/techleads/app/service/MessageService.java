package com.techleads.app.service;

import org.springframework.stereotype.Service;

import com.techleads.app.model.Message;

@Service
public class MessageService {
	
	public String myMessage() {
		return "Pay the airtel bill";
	}
	
	
	public String saveMessage(Message msg) {
		System.out.println(msg);
		return "message is saved with id: "+msg.getId();
	}

}
