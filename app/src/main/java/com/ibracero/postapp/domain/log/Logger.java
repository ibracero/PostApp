package com.ibracero.postapp.domain.log;

public interface Logger {

    void i(String tag, String message);

    void v(String tag, String message);

    void d(String tag, String message);

    void e(String tag, String message, Throwable error);
}