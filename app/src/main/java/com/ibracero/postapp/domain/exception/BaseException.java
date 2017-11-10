package com.ibracero.postapp.domain.exception;

class BaseException extends RuntimeException{

    protected  int code;

    public BaseException(int code) {
        this.code = code;
    }

    public BaseException(String s, int code) {
        super(s);
        this.code = code;
    }

    public BaseException(String s, Throwable throwable, int code) {
        super(s, throwable);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
