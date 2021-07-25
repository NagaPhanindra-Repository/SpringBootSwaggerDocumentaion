package com.codemer.giftcard.model;

import io.swagger.annotations.ApiModel; 
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "This model contains all details about contactForm. ") 
public class consents { @ApiModelProperty(notes = "Information if this consent is approved") private boolean SFS1;

@ApiModelProperty(notes = "Information if this consent is approved")
private boolean SFS2;

@ApiModelProperty(notes = "Information if this consent is approved")
private boolean SFS3;

@ApiModelProperty(notes = "Information if this consent is approved")
private boolean BNP1;


@ApiModelProperty(notes = "Information if this consent is approved")
private boolean BNP2;


public boolean isSFS1() {
	return SFS1;
}


public void setSFS1(boolean sFS1) {
	SFS1 = sFS1;
}


public boolean isSFS2() {
	return SFS2;
}


public void setSFS2(boolean sFS2) {
	SFS2 = sFS2;
}


public boolean isSFS3() {
	return SFS3;
}


public void setSFS3(boolean sFS3) {
	SFS3 = sFS3;
}


public boolean isBNP1() {
	return BNP1;
}


public void setBNP1(boolean bNP1) {
	BNP1 = bNP1;
}


public boolean isBNP2() {
	return BNP2;
}


public void setBNP2(boolean bNP2) {
	BNP2 = bNP2;
}
}