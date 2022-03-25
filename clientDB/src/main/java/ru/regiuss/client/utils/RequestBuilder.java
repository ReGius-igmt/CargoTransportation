package ru.regiuss.client.utils;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class RequestBuilder {

    private final StringBuilder url;
    private Method method;
    private byte[] date;
    private final Map<String, String> pathParams;
    private final Map<String, String> properties;

    public RequestBuilder(String url){
        this.url = new StringBuilder(url);
        if(this.url.charAt(this.url.length()-1) == '/')this.url.deleteCharAt(this.url.length()-1);
        this.pathParams = new HashMap<>();
        this.properties = new HashMap<>();
        this.method = Method.GET;
    }

    public RequestBuilder addPath(String key, Object value){
        pathParams.put(key, value.toString());
        return this;
    }

    public RequestBuilder removePath(String key, String value){
        pathParams.remove(key);
        return this;
    }

    public RequestBuilder addProperty(String key, String value){
        properties.put(key, value);
        return this;
    }

    public RequestBuilder removeProperty(String key, String value){
        properties.remove(key);
        return this;
    }

    public RequestBuilder setDate(byte[] date){
        this.date = date;
        return this;
    }

    public HttpURLConnection build(){
        try {
            if(pathParams.size() > 0){
                url.append("?");
                pathParams.forEach((key, val) -> {
                    url.append(key).append("=").append(val).append("&");
                });
                url.deleteCharAt(url.length()-1);
            }
            HttpURLConnection con = (HttpURLConnection)new URL(url.toString()).openConnection();
            con.setRequestMethod(method.name());
            properties.forEach(con::addRequestProperty);
            con.connect();
            if(this.date != null){
                con.setDoOutput(true);
                con.getOutputStream().write(date);
            }
            return con;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public enum Method{
        GET, POST, PUT;
    }
}
