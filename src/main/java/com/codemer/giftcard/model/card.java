package com.codemer.giftcard.model;

import io.swagger.annotations.ApiModel; 
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "This model contains all details about CardInfo. ")
public class card {

@ApiModelProperty(notes = "This field will gives you the value of Card BIN")
private String cardBIN;

@ApiModelProperty(notes = "This field will gives you the vaue of Card brand")
private String cardBrand;

@ApiModelProperty(notes = "This field will gives you the value of cardHolderName")
private String cardHolderName;

@ApiModelProperty(notes = "This field will gives you the value of Valid NIF number 9 digits")
private String cardHolderNIF;


@ApiModelProperty(notes = "This field will gives you the value of cardIdentifier")
private String cardIdentifier;

@ApiModelProperty(notes = "This field will gives you the value of cardStatus")
private String cardStatus;


@ApiModelProperty(notes = "This field will gives you the vaue of cardNumber")
private String cardNumber;

@ApiModelProperty(notes = "This field will gives you the value of Card expiry date")
private String expiryDate;

@ApiModelProperty(notes = "This field will gives you the value of Card registra-tion date")
private String registrationDate;

public String getCardBIN() {
	return cardBIN;
}

public void setCardBIN(String cardBIN) {
	this.cardBIN = cardBIN;
}

public String getCardBrand() {
	return cardBrand;
}

public void setCardBrand(String cardBrand) {
	this.cardBrand = cardBrand;
}

public String getCardHolderName() {
	return cardHolderName;
}

public void setCardHolderName(String cardHolderName) {
	this.cardHolderName = cardHolderName;
}

public String getCardHolderNIF() {
	return cardHolderNIF;
}

public void setCardHolderNIF(String cardHolderNIF) {
	this.cardHolderNIF = cardHolderNIF;
}

public String getCardIdentifier() {
	return cardIdentifier;
}

public void setCardIdentifier(String cardIdentifier) {
	this.cardIdentifier = cardIdentifier;
}

public String getCardStatus() {
	return cardStatus;
}

public void setCardStatus(String cardStatus) {
	this.cardStatus = cardStatus;
}

public String getCardNumber() {
	return cardNumber;
}

public void setCardNumber(String cardNumber) {
	this.cardNumber = cardNumber;
}

public String getExpiryDate() {
	return expiryDate;
}

public void setExpiryDate(String expiryDate) {
	this.expiryDate = expiryDate;
}

public String getRegistrationDate() {
	return registrationDate;
}

public void setRegistrationDate(String registrationDate) {
	this.registrationDate = registrationDate;
}
}