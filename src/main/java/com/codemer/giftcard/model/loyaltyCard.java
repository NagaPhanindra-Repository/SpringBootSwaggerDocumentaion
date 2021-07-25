package com.codemer.giftcard.model;



import io.swagger.annotations.ApiModel; 
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "This model contains all details about loyalty Crad. ") 
public class loyaltyCard {

@ApiModelProperty(notes = "This field will gives you the loyalty")
private String loyalty;

@ApiModelProperty(notes = "This field will gives you the mainCardLoyalty")
private String mainCardLoyalty;


@ApiModelProperty(notes = "This field will gives you the session ID")
private String sessionId;

@ApiModelProperty(notes = "This field will gives you the token value")
private String token;

public loyaltyCard(){
	
}




public loyaltyCard(String loyalty, String mainCardLoyalty, int resultCode,
		String sessionId, String token) {
	super();
	this.loyalty = loyalty;
	this.mainCardLoyalty = mainCardLoyalty;
	
	this.sessionId = sessionId;
	this.token = token;
}




public String getToken() {
	return token;
}




public void setToken(String token) {
	this.token = token;
}




public String getLoyalty() {
	return loyalty;
}

public void setLoyalty(String loyalty) {
	this.loyalty = loyalty;
}

public String getMainCardLoyalty() {
	return mainCardLoyalty;
}

public void setMainCardLoyalty(String mainCardLoyalty) {
	this.mainCardLoyalty = mainCardLoyalty;
}


public String getSessionId() {
	return sessionId;
}

public void setSessionId(String sessionId) {
	this.sessionId = sessionId;
}
}