package com.claro.julio.resources.exception;

import java.io.Serializable;
//3
public class StandardError implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer status;
	private String msg;
	private Long timestamp;
	private String error;
	private String path;

	public StandardError(Long timestamp, Integer status, String error, String msg, String path) {
		super();
		this.status = status;
		this.msg = msg;
		this.timestamp = timestamp;
		this.error=error;
		this.path=path;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	
	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
