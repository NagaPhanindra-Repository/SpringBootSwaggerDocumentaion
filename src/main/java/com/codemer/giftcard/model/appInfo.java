package com.codemer.giftcard.model;

import io.swagger.annotations.ApiModel; 
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "This model contains all details about Application. ")
public class appInfo {
	

		@ApiModelProperty(notes = "This field will gives you the version ID")
		private String apiVersion;

		@ApiModelProperty(notes = "This field will gives you time stamp")
		private String	timestamp;

		@ApiModelProperty(notes = "This field will gives you the buildNum")
		private String buildNum;

		public appInfo(String apiVersion, String timestamp, String buildNum) {
			super();
			this.apiVersion = apiVersion;
			this.timestamp = timestamp;
			this.buildNum = buildNum;
		}
		public String getApiVersion() {
			return apiVersion;
		}
		public void setApiVersion(String apiVersion) {
			this.apiVersion = apiVersion;
		}
		public String getTimestamp() {
			return timestamp;
		}
		public void setTimestamp(String timestamp) {
			this.timestamp = timestamp;
		}
		public String getBuildNum() {
			return buildNum;
		}
		public void setBuildNum(String buildNum) {
			this.buildNum = buildNum;
		}
}

