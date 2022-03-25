package ru.regiuss.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.regiuss.client.model.Point;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println(new ObjectMapper().writeValueAsString(new Point(2, 2, 2)));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        //App.launch(App.class, args);
    }
}
