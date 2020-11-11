package com.gp.cms.common.exception;

public class NullParamException extends RuntimeException {
    private static final long serialVersionUID = -4225163792615176555L;

    public NullParamException(String msg) {
        super(msg);
    }
}
