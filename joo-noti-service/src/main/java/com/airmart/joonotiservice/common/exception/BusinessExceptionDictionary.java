package com.airmart.joonotiservice.common.exception;

import lombok.Getter;

@Getter
public enum BusinessExceptionDictionary {
	UNKNOWN("Unknown", "E000");

	private final String reason;
	private final String code;

	BusinessExceptionDictionary(final String reason, final String code){
		this.reason = reason;
		this.code = code;
	}


}
