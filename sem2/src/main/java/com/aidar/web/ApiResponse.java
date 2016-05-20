package com.aidar.web;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * Created by paradise on 17.05.16.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse {

    private HttpResponse httpResponse;

    private Object responseData;

    private List<String> errors;

    public HttpResponse getHttpResponse() {
        return httpResponse;
    }

    public void setHttpResponse(HttpResponse httpResponse) {
        this.httpResponse = httpResponse;
    }

    public Object getResponseData() {
        return responseData;
    }

    public void setResponseData(Object responseData) {
        this.responseData = responseData;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setError(List<String> errors) {
        this.errors = errors;
    }

    public void addError(String error) {
        errors.add(error);
    }

}
