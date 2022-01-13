package com.project.exceptions;

import java.util.Date;

public class ErrorResponse {

	private Date timeStamp;
	private int status;
	private String error;
	private String message;
	private String path;
	
	public ErrorResponse(int status, String error, String message, String path) {
		
		this.timeStamp = new Date(System.currentTimeMillis());
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}







