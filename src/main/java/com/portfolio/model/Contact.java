package com.portfolio.model;

import java.sql.Timestamp;

public class Contact {
	private String id; // UUID
	private String name;
	private String email;
	private String message;
	private Timestamp createdAt; // 등록 시간
	private int completed;

	// 생성자
	public Contact(String id, String name, String email, String message, Timestamp createdAt, int completed) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.message = message;
		this.createdAt = createdAt;
		this.completed = completed;
	}

	// Getter & Setter
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public int getCompleted() {
		return completed;
	}

	public void setCompleted(int completed) {
		this.completed = completed;
	}
	
	

}
