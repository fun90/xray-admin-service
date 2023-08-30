package com.fun90.admin.constant.enumObject;

public enum StatusEnum {

	SUCCESS(1), FAIL(0);
	private Integer code;

	StatusEnum(Integer code) {
		this.code = code;
	}

	public Integer code() {
		return code;
	}
}
