package com.techleads.app.model;

public class Message {

	private Integer id;
	private String name;
	
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Message(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Message [id=" + id + ", name=" + name + "]";
	}
	
}
