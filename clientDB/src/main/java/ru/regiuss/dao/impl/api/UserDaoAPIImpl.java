package ru.regiuss.dao.impl.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.regiuss.dao.UserDao;
import ru.regiuss.model.User;
import ru.regiuss.utils.RequestBuilder;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class UserDaoAPIImpl implements UserDao {

    private final String baseURL = "http://127.0.0.1:7000";

    @Override
    public List<User> getAll() {
        HttpURLConnection con = new RequestBuilder(baseURL + "/users").build();
        String resp;
        try {
            resp = new String(con.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
            ObjectMapper om = new ObjectMapper();
            JsonNode jsonNode = om.readTree(resp);
            return om.convertValue(jsonNode.get("content"), new TypeReference<List<User>>(){});
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User get() {
        return null;
    }

    @Override
    public void save(User user) {

    }

    @Override
    public void remove(User user) {

    }

    @Override
    public long count() {
        HttpURLConnection con = new RequestBuilder(baseURL + "/users")
                .addPath("limit", 1).build();
        String resp;
        try {
            resp = new String(con.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
            ObjectMapper om = new ObjectMapper();
            JsonNode jsonNode = om.readTree(resp);
            return jsonNode.get("totalElements").asLong();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<User> getAllPage(int page, int size) {
        HttpURLConnection con = new RequestBuilder(baseURL + "/users")
                .addPath("page", page)
                .addPath("limit", size).build();
        String resp;
        try {
            resp = new String(con.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
            ObjectMapper om = new ObjectMapper();
            JsonNode jsonNode = om.readTree(resp);
            return om.convertValue(jsonNode.get("content"), new TypeReference<List<User>>(){});
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
