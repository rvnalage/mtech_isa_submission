package org.example.dtos;

public class Request {

    private final Integer requestId;

    public Request(Integer requestId) {
        this.requestId = requestId;
    }

    public Integer getRequestId() {
        return requestId;
    }
}
