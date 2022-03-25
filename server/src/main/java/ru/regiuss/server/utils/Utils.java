package ru.regiuss.server.utils;

public class Utils {
    public static String getHash(byte[] bytes){
        StringBuilder builder = new StringBuilder(bytes.length*2);
        for (byte b : bytes) {
            builder.append(String.format("%02x", b));
        }
        return builder.toString();
    }
}
