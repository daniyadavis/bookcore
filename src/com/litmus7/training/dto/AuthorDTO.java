package com.litmus7.training.dto;

public class AuthorDTO {
	private int id;
	private String name;
	
	public AuthorDTO(String name, int id) {
		
		this.id=id;
		this.name=name;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
