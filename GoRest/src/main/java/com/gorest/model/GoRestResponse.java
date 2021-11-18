package com.gorest.model;

public class GoRestResponse {
    private Object meta;
    private Object data;

    public GoRestResponse(Object meta, Object data) {
        this.meta = meta;
        this.data = data;
    }

    public GoRestResponse() {};


    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getMeta() {
        return meta;
    }

    public void setMeta(Object meta) {
        this.meta = meta;
    }
}
