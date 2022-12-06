package com.example.demo_project.constants;

public enum RtnInfo {
	SUCCESSFUL("200", "Successful"), 
	PARAMETER_REQUIRED("400", "Require parameter."),
	FAILED("500", "Failed."),
	DATA_REQUIRED("417", "Please enter full data.");

	private String code;

	private String message;

	private RtnInfo(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}
