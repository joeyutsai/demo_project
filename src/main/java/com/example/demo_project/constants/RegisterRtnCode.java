package com.example.demo_project.constants;

public enum RegisterRtnCode {
	SUCCESSFUL("200", "Successful"),
	ACCOUNT_REQUIRED("400", "Account cannot be null or empty."),
	PWD_REQUIRED("400", "Pwd cannot be null or empty."),
	NAME_REQUIRED("400", "Name cannot be null or empty."),
	ACCOUNT_EXISTED("403", "Account has existed."),
	FAIL("400","Account active fail."),
	ADD_ROLE_FAILURE("400","Add role fail."),
	ROLE_LIST_IS_EMPTY("400","Role list is empty.");
	
	private String code;
	
	private String message;
	
	private RegisterRtnCode(String code, String message) {
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
