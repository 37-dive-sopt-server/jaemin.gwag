package com.divesoptserver37.global.exception;

import com.divesoptserver37.global.exception.code.ErrorCode;

public class InvalidValueException extends BusinessException {
    public InvalidValueException(ErrorCode errorCode) {
        super(errorCode);
    }
}
