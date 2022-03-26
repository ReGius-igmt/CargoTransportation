package ru.regiuss.cargotransportation.server.exception;

public class UserNotFoundException extends CustomException{
    public UserNotFoundException(int userId) {
        super(new ExceptionInfo(1, String.format("Пользователь [%s] не найден",userId)));
    }
}
