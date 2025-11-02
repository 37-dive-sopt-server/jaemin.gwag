package com.divesoptserver37.global.exception;

import com.divesoptserver37.global.exception.code.ErrorCode;

public class NotFoundException extends BusinessException {
    public NotFoundException(final ErrorCode errorCode) {
        super(errorCode);
    }
}
