package ru.sbrf.learnqa.soxshop.payload;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(fluent = true)
public class UserPayload{

	@JsonProperty("password")
	private String password;
	@JsonProperty("email")
	private String email;
	@JsonProperty("username")
	private String username;

	@Override
 	public String toString(){
		return
			"UserPayload{" +
			"password = '" + password + '\'' +
			", email = '" + email + '\'' +
			", username = '" + username + '\'' +
			"}";
		}
}
