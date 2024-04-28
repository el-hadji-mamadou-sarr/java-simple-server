package org.example;

public class HttpConfigurationExeption extends RuntimeException{
    public HttpConfigurationExeption() {
    }

    public HttpConfigurationExeption(String message) {
        super(message);
    }

    public HttpConfigurationExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public HttpConfigurationExeption(Throwable cause) {
        super(cause);
    }

    public HttpConfigurationExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
