package org.example.demo_ekz.models;

public class Comment {
    private int commentID; // Идентификатор комментария
    private String message; // Сообщение комментария
    private int masterID; // Идентификатор мастера (пользователя)
    private int requestID; // Идентификатор заявки

    // Конструктор
    public Comment(String message, int masterID, int requestID) {
        this.message = message;
        this.masterID = masterID;
        this.requestID = requestID;
    }

    // Геттеры и сеттеры
    public int getCommentID() {
        return commentID; // Возвращает идентификатор комментария
    }

    public String getMessage() {
        return message; // Возвращает сообщение комментария
    }

    public void setMessage(String message) {
        this.message = message; // Устанавливает идентификатор комментария
    }

    public int getMasterID() {
        return masterID; // Возвращает идентификатор мастера
    }

    public void setMasterID(int masterID) {
        this.masterID = masterID; // Устанавливает идентификатор комментария
    }

    public int getRequestID() {
        return requestID; // Возвращает идентификатор заявки (не меняется)
    }

}
