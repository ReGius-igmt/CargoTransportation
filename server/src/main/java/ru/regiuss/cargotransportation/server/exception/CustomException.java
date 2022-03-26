package ru.regiuss.cargotransportation.server.exception;

public abstract class CustomException extends RuntimeException{

    private ExceptionInfo info;

    public CustomException(ExceptionInfo info){
        this.info = info;
    }

    public ExceptionInfo getInfo() {
        return info;
    }

    public static class ExceptionInfo{
        protected int id;
        protected String message;
        protected String description;

        public ExceptionInfo() {
            id = 0;
            message = "Неизвестная ошибка";
            description = message;
        }

        public ExceptionInfo(int id, String message) {
            this.id = id;
            this.message = message;
            this.description = message;
        }

        public ExceptionInfo(int id, String message, String description) {
            this.id = id;
            this.message = message;
            this.description = description;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }

}
