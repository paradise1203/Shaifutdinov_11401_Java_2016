package com.aidar.util;

/**
 * Created by paradise on 17.05.16.
 */
public enum HttpResponse {

    SUCCESS(200, "Success"),
    FAIL(400, "Fail");

    private int code;
    private String msg;

    HttpResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
