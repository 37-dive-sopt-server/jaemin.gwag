package com.divesoptserver37.global.exception;

import com.divesoptserver37.global.exception.code.ErrorCode;

public class ForbiddenException extends BusinessException {
    public ForbiddenException(ErrorCode errorCode) {
        super(errorCode);
    }
}

