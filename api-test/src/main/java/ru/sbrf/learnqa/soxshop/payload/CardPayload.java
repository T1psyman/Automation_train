package ru.sbrf.learnqa.soxshop.payload;

import com.fasterxml.jackson.annotation.JsonProperty;  //Зачем нужен джексон????

public class CardPayload{

	@JsonProperty("expires")
	private String expires;

	@JsonProperty("longNum")
	private String longNum;

	@JsonProperty("ccv")
	private String ccv;

	@JsonProperty("userID")
	private String userID;

	public void setExpires(String expires){
		this.expires = expires;
	}

	public String getExpires(){
		return expires;
	}

	public void setLongNum(String longNum){
		this.longNum = longNum;
	}

	public String getLongNum(){
		return longNum;
	}

	public void setCcv(String ccv){
		this.ccv = ccv;
	}

	public String getCcv(){
		return ccv;
	}

	public void setUserID(String userID){
		this.userID = userID;
	}

	public String getUserID(){
		return userID;
	}

	@Override
 	public String toString(){
		return 
			"CardPayload{" + 
			"expires = '" + expires + '\'' + 
			",longNum = '" + longNum + '\'' + 
			",ccv = '" + ccv + '\'' + 
			",userID = '" + userID + '\'' + 
			"}";
		}
}