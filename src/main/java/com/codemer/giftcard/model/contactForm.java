package com.codemer.giftcard.model;

import io.swagger.annotations.ApiModel; 
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "This model contains all details about contactForm. ") 
public class contactForm {

@ApiModelProperty(notes = "This field will gives you the lista Constant Value")
private String lista;

@ApiModelProperty(notes = "This field will gives you the Form client id. Constant Value")
private String cliente;


@ApiModelProperty(notes = "This field will gives you the Constant Value lang")
private String lang;

@ApiModelProperty(notes = "This field will gives you the formid value")
private String formid;

@ApiModelProperty(notes = "This field will gives you the First name value")
private String fname_77;

@ApiModelProperty(notes = "This field will gives you the Last name")
private String lname_78;


@ApiModelProperty(notes = "This field will gives you the Client number")
private String campoe_27_79;

@ApiModelProperty(notes = "This field will gives you the Email value")
private String email_75;

@ApiModelProperty(notes = "This field will gives you the Tel. country code ")
private String ind_telemovel_76;

@ApiModelProperty(notes = "This field will gives you the Mobile phone")
private String telemovel_76_numero;


@ApiModelProperty(notes = "This field will gives you the Subject id See Message subject list below")
private String campoe_31_81;

@ApiModelProperty(notes = "This field will gives you the Message value")
private String campoe_29_80;

public String getLista() {
	return lista;
}

public void setLista(String lista) {
	this.lista = lista;
}

public String getCliente() {
	return cliente;
}

public void setCliente(String cliente) {
	this.cliente = cliente;
}

public String getLang() {
	return lang;
}

public void setLang(String lang) {
	this.lang = lang;
}

public String getFormid() {
	return formid;
}

public void setFormid(String formid) {
	this.formid = formid;
}

public String getFname_77() {
	return fname_77;
}

public void setFname_77(String fname_77) {
	this.fname_77 = fname_77;
}

public String getLname_78() {
	return lname_78;
}

public void setLname_78(String lname_78) {
	this.lname_78 = lname_78;
}

public String getCampoe_27_79() {
	return campoe_27_79;
}

public void setCampoe_27_79(String campoe_27_79) {
	this.campoe_27_79 = campoe_27_79;
}

public String getEmail_75() {
	return email_75;
}

public void setEmail_75(String email_75) {
	this.email_75 = email_75;
}

public String getInd_telemovel_76() {
	return ind_telemovel_76;
}

public void setInd_telemovel_76(String ind_telemovel_76) {
	this.ind_telemovel_76 = ind_telemovel_76;
}

public String getTelemovel_76_numero() {
	return telemovel_76_numero;
}

public void setTelemovel_76_numero(String telemovel_76_numero) {
	this.telemovel_76_numero = telemovel_76_numero;
}

public String getCampoe_31_81() {
	return campoe_31_81;
}

public void setCampoe_31_81(String campoe_31_81) {
	this.campoe_31_81 = campoe_31_81;
}

public String getCampoe_29_80() {
	return campoe_29_80;
}

public void setCampoe_29_80(String campoe_29_80) {
	this.campoe_29_80 = campoe_29_80;
}
}