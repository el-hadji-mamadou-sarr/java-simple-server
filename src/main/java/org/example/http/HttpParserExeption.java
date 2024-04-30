package org.example.http;

public class HttpParserExeption extends Exception{
    private final  HttpStatusCode errorCode;

    public HttpParserExeption(HttpStatusCode errorCode) {
        super(errorCode.MESSAGE);
        this.errorCode = errorCode;
    }
    public HttpStatusCode getErrorCode() {
        return errorCode;
    }


}
