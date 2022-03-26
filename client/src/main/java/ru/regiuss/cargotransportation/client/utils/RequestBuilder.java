package ru.regiuss.cargotransportation.client.utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class RequestBuilder {
    private final StringBuilder url;
    private Method method;
    private final Map<String, String> pathParams;
    private final Map<String, String> properties;
    private byte[] data;

    public RequestBuilder(String url){
        this.url = new StringBuilder(url);
        if(this.url.charAt(this.url.length()-1) == '/')this.url.deleteCharAt(this.url.length()-1);
        this.pathParams = new HashMap<>(4);
        this.properties = new HashMap<>(4);
    }

    public RequestBuilder setMethod(Method method){
        this.method = method;
        return this;
    }

    public RequestBuilder addPath(String key, String value){
        this.pathParams.put(key, value);
        return this;
    }

    public RequestBuilder removePath(String key){
        this.pathParams.remove(key);
        return this;
    }

    public RequestBuilder addProperty(String key, String value){
        this.properties.put(key, value);
        return this;
    }

    public RequestBuilder removeProperty(String key){
        this.properties.remove(key);
        return this;
    }

    public RequestBuilder setData(byte[] data){
        this.data = data;
        return this;
    }

    public HttpURLConnection build(){
        try {
            if(pathParams.size() > 0){
                url.append("?");
                pathParams.forEach((s, s2) -> {
                    url.append(s).append('=').append(s2).append('&');
                });
                url.deleteCharAt(url.length()-1);
            }
            HttpURLConnection con = (HttpURLConnection) new URL(url.toString()).openConnection();
            con.setRequestMethod(method.name());
            properties.forEach(con::addRequestProperty);
            if(data != null){
                con.setDoOutput(true);
                con.getOutputStream().write(data);
            }
            return con;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public enum Method{
        GET, POST, PUT, DELETE
    }
}
