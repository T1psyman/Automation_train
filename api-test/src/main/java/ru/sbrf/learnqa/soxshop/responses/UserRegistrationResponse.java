package ru.sbrf.learnqa.soxshop.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserRegistrationResponse{

	@JsonProperty("id")
	private String id;

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}
}