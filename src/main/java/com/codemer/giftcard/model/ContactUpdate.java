package com.codemer.giftcard.model;

import io.swagger.annotations.ApiModel; 
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "This model contains all details about contactForm. ") 
public class ContactUpdate {

@ApiModelProperty(notes = "This field will gives you the User’s street name")
private String streetName;

@ApiModelProperty(notes = "This field will gives you the User’s house number")
private String houseNum;


@ApiModelProperty(notes = "This field will gives you the User’s postal code")
private String postcode;

@ApiModelProperty(notes = "This field will gives you the User’s city name")
private String city;

@ApiModelProperty(notes = "This field will gives you the User’s home phone numberValue may be empty (reset data)")
private String phone;

@ApiModelProperty(notes = "User’s mobile phone numberValue may be empty (reset data)")
private String mobile;

@ApiModelProperty(notes = "User’s e-mail address Value may be empty ")
private String email;

public String getStreetName() {
	return streetName;
}

public void setStreetName(String streetName) {
	this.streetName = streetName;
}

public String getHouseNum() {
	return houseNum;
}

public void setHouseNum(String houseNum) {
	this.houseNum = houseNum;
}

public String getPostcode() {
	return postcode;
}

public void setPostcode(String postcode) {
	this.postcode = postcode;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public String getPhone() {
	return phone;
}

public void setPhone(String phone) {
	this.phone = phone;
}

public String getMobile() {
	return mobile;
}

public void setMobile(String mobile) {
	this.mobile = mobile;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}
}