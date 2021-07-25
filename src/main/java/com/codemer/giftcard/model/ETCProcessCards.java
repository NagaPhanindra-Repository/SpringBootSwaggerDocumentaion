package com.codemer.giftcard.model;


import io.swagger.annotations.ApiModel; 
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "This model contains all details about ETCProcess Cards. ") 
public class ETCProcessCards {

@ApiModelProperty(notes = "This field will gives you the value of Valid client number (9 digits)")
private String nif;

@ApiModelProperty(notes = "This field will gives you the vaue of PVL number (16 digits)")
private String pvl;

@ApiModelProperty(notes = "This field will gives you the value of Revolving % of credit account amortization (op-tional, present if status SUCCESS)")
private String degressivity;

@ApiModelProperty(notes = "This field will gives you the value of ETC Number (16 digits)")
private String etc;


@ApiModelProperty(notes = "This field will gives you the value of Card number (PAN)")
private String cardNumber;

@ApiModelProperty(notes = "This field will gives you the vaue of Multichannel Code")
private String MCCode;

@ApiModelProperty(notes = "This field will gives you the value of Sequence number")
private String seqNum;

@ApiModelProperty(notes = "This field will gives you the value of String value of loyalty identifier")
private String loyaltyId;

@ApiModelProperty(notes = "This field will gives you the value of Id of public key")
private String publicKeyId;


@ApiModelProperty(notes = "This field will gives you the value of New PIN value en-crypted with RSA al-gorithm, us-ing a publicKey ")
private String encryptedPin;

@ApiModelProperty(notes = "This field will gives you the value of Old Multichannel ")
private String oldMCCode;

@ApiModelProperty(notes = "This field will gives you the value of New Multichannel Code")
private String newMCCode;









public ETCProcessCards(){
	
}


public String getEtc() {
	return etc;
}


public void setEtc(String etc) {
	this.etc = etc;
}





public String getCardNumber() {
	return cardNumber;
}


public void setCardNumber(String cardNumber) {
	this.cardNumber = cardNumber;
}


public String getMCCode() {
	return MCCode;
}


public void setMCCode(String mCCode) {
	MCCode = mCCode;
}


public String getSeqNum() {
	return seqNum;
}


public void setSeqNum(String seqNum) {
	this.seqNum = seqNum;
}


public String getLoyaltyId() {
	return loyaltyId;
}


public void setLoyaltyId(String loyaltyId) {
	this.loyaltyId = loyaltyId;
}


public String getPublicKeyId() {
	return publicKeyId;
}


public void setPublicKeyId(String publicKeyId) {
	this.publicKeyId = publicKeyId;
}


public String getEncryptedPin() {
	return encryptedPin;
}


public void setEncryptedPin(String encryptedPin) {
	this.encryptedPin = encryptedPin;
}


public String getOldMCCode() {
	return oldMCCode;
}


public void setOldMCCode(String oldMCCode) {
	this.oldMCCode = oldMCCode;
}


public String getNewMCCode() {
	return newMCCode;
}


public void setNewMCCode(String newMCCode) {
	this.newMCCode = newMCCode;
}


public String getNif() {
	return nif;
}

public void setNif(String nif) {
	this.nif = nif;
}

public String getPvl() {
	return pvl;
}

public void setPvl(String pvl) {
	this.pvl = pvl;
}

public String getDegressivity() {
	return degressivity;
}

public void setDegressivity(String degressivity) {
	this.degressivity = degressivity;
}
}