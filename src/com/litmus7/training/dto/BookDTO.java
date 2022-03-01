package com.litmus7.training.dto;

import java.util.ArrayList;
import java.util.List;

public class BookDTO {

	private int id;
	private String name;
	private List<AuthorDTO> authors;

	public BookDTO(int id, String name) {
		this.id=id;
		this.name=name;
	}

	public BookDTO() {
		// TODO Auto-generated constructor stub
	}

	public BookDTO(int id, String name, List<AuthorDTO> authors) {
		this.id=id;
		this.name=name;
		this.authors=authors;
	}

	public List<String> getAuthors() {
		List<String> str =new ArrayList<String>();
		for(AuthorDTO author:authors) {
			str.add(author.getName());
		}
		return str;
	}

	public void setAuthors(List<AuthorDTO> authors) {
		this.authors = authors;
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
