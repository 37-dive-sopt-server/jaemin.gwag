package com.divesoptserver37.global.exception;

import com.divesoptserver37.global.exception.code.ErrorCode;

public class BadRequestException extends BusinessException {

    public BadRequestException(ErrorCode errorCode) {
        super(errorCode);
    }
}

