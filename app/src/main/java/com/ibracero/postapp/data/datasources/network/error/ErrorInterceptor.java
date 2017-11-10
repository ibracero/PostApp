package com.ibracero.postapp.data.datasources.network.error;

import com.ibracero.postapp.domain.exception.GeneralWebServiceException;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.Interceptor;
import okhttp3.Response;

public class ErrorInterceptor implements Interceptor {

    @Inject
    public ErrorInterceptor() {
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Response response = chain.proceed(chain.request());

        if (!response.isSuccessful()) {
            throw getExceptionFromCode(response.code());
        } else {
            return response;
        }

    }

    private RuntimeException getExceptionFromCode(int code) {
        switch (code) {
            default:
                return new GeneralWebServiceException("Internal error!", code);
        }
    }
}
