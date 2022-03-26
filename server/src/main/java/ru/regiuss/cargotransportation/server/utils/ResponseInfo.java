package ru.regiuss.cargotransportation.server.utils;

public class ResponseInfo{
    private final boolean success;
    private final Object data;

    public ResponseInfo(boolean success, Object data) {
        this.success = success;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public Object getData() {
        return data;
    }
}
